package tangier.assets;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

public class Player extends JPanel {
    private Cue cue;
    private ArrayList<Ball> balls;

    public Player() {
        super();
        cue = new Cue();
        balls = new ArrayList<Ball>();
    }

    public Cue getCue() {
        return cue;
    }

    public void pocketBall(Ball b) {
        int n = b.getNumber();
        b.setPos((n < 9) ? 20 : 945, 135 + 70 * (n % 8));
        balls.add(b);
    }

    public void paintComponent(Graphics g, Ball cueball, int mx, int my, Boolean turn) {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).paintComponent(g);
        }

        if (turn) {
            cue.paintComponent(g, cueball, mx, my);
        }
    }
}
