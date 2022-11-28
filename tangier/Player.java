package tangier;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;

class Player extends JPanel {
    Cue cue;

    public Player() {
        super();
        this.cue = new Cue();
    }

    public void paintComponent(Graphics g, int cbx, int cby, int mx, int my) {
        this.cue.paintComponent(g, cbx, cby, mx, my);
    }
}
