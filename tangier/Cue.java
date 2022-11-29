package tangier;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

class Cue extends JPanel {
    public Cue() {
        super();
    }

    public void paintComponent(Graphics g, int cbx, int cby, int mx, int my) {
        int cx = cbx + 15;
        int cy = cby + 15;
        double theta;

        if (mx >= cx) {
            if (my >= cy) {
                theta = Math.atan((my - cy) / (double) (mx - cx));
            }
            else {
                theta = 2 * Math.PI + Math.atan((my - cy) / (double) (mx - cx));
            }
        }
        else {
            if (my >= cy) {
                theta = Math.PI / 2 - Math.atan((mx - cbx - 15) / (double) (my - cby - 15));
            }
            else {
                theta = Math.PI + Math.atan((my - cy) / (double) (mx - cx));
            }
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(105, 69, 12));

        Rectangle2D.Double rect = new Rectangle2D.Double(cx, cy, 10, 300);

        AffineTransform r = new AffineTransform();
        AffineTransform t = new AffineTransform();

        r.rotate(theta - Math.PI / 2, cx, cy);
        t.translate(20 * Math.cos(theta) - 5 * Math.sin(theta), 20 * Math.sin(theta) + 5 * Math.cos(theta));

        g2.fill(t.createTransformedShape(r.createTransformedShape(rect)));
        g2.setColor(Color.black);
        g2.draw(t.createTransformedShape(r.createTransformedShape(rect)));
    }
}
