package tangier;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Cue extends JPanel {
    public Cue() {
        super();
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(105, 69, 12));
        g.fillRect(200, 200, 10, 300);
    }
}
