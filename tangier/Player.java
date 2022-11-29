package tangier;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;

class Player extends JPanel {
    public Cue cue;

    public Player() {
        super();
        this.cue = new Cue();
    }

    public void paintComponent(Graphics g, CueBall cb, int mx, int my) {
        this.cue.paintComponent(g, cb, mx, my);
    }
}
