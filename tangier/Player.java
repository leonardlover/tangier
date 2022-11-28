package tangier;
import java.awt.Graphics;
import javax.swing.JPanel;

class Player extends JPanel {
    Cue cue;

    public Player() {
        super();
        this.cue = new Cue();
    }

    public void paintComponent(Graphics g) {
        this.cue.paintComponent(g);
    }
}
