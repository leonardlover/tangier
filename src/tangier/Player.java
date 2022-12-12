package tangier;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

/** Player class, implements the interaction of the player with the
 *  rack and the table so that the games flows correctly.
 *  @author clau
 *  @author leo */
class Player extends JPanel {
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

    /** If a ball enters a pocket, then
     *  store it in the player's set of balls
     *  and display it in the correct point counter.
     *  @param b, the ball that was just pocketed.
     * */
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
