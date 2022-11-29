package tangier;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

class Cue extends JPanel {
    public double theta;

    public Cue() {
        super();
        this.theta = 0;
    }

    public void hitBall(CueBall ball) {
        if (!ball.isMoving) {
            ball.vx = Math.cos(theta);
            ball.vy = Math.sin(theta);
            ball.isMoving = true;
        }
    }

    public void paintComponent(Graphics g, CueBall cb, int mx, int my) {
        int cx = cb.x + 15;
        int cy = cb.y + 15;

        theta = Math.atan2(my - cy, mx - cx);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(105, 69, 12));

        if (!cb.isMoving) {
            Rectangle2D.Double rect = new Rectangle2D.Double(cx, cy, 10, 300);

            AffineTransform r = new AffineTransform();
            AffineTransform t = new AffineTransform();

            r.rotate(theta - Math.PI / 2, cx, cy);
            t.translate(20 * Math.cos(theta) - 5 * Math.sin(theta), 20 * Math.sin(theta) + 5 * Math.cos(theta));

            g2.fill(t.createTransformedShape(r.createTransformedShape(rect)));
            g2.setColor(Color.black);
            g2.draw(t.createTransformedShape(r.createTransformedShape(rect)));
        }

        else {
            Rectangle2D.Double rect = new Rectangle2D.Double(50, 200, 10, 300);
            g2.fill(rect);
            g2.setColor(Color.black);
            g2.draw(rect);
        }
    }
}
