package tangier;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;

class Cue extends JPanel {
    private double angle;

    public Cue() {
        super();
        angle = 0.0;
    }

    public double getAngle() {
        return angle;
    }

    public void paintComponent(Graphics g, Ball cueball, int mx, int my) {
        int cx = cueball.getX() + 15;
        int cy = cueball.getY() + 15;

        angle = Math.atan2(my - cy, mx - cx);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(105, 69, 12));

        if (!cueball.isMoving()) {
            Rectangle2D.Double rect = new Rectangle2D.Double(cx, cy, 10, 300);

            AffineTransform r = new AffineTransform();
            AffineTransform t = new AffineTransform();

            r.rotate(angle - Math.PI / 2, cx, cy);
            t.translate(20 * Math.cos(angle) - 5 * Math.sin(angle), 20 * Math.sin(angle) + 5 * Math.cos(angle));

            g2.fill(t.createTransformedShape(r.createTransformedShape(rect)));
            g2.setColor(Color.black);
            g2.draw(t.createTransformedShape(r.createTransformedShape(rect)));
        }
    }
}
