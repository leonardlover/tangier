package tangier;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
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

        g.setColor(new Color(105, 69, 12));
        g.fillRect(cx + (int) (20 * Math.cos(theta)), cy + (int) (20 * Math.sin(theta)), 10, 300);
        System.out.println(Math.cos(theta) + " " + Math.sin(theta));
    }
}
