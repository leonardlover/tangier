package tangier;
import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;

class Ball extends JPanel {
    public int x;
    public int y;
    public double vx;
    public double vy;
    public Color color;
    public Random rand;
    public boolean isMoving;
    public String number;

    public Ball(Color color, String num, int x, int y) {
        super();
        rand = new Random();
        this.color = color;
        number = num;
        this.x = x;
        this.y = y;
        vx = 0;
        vy = 0;
        isMoving = false;
    }
}
