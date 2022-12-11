package tangier;
import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;
import java.util.ArrayList;

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

    public void move(ArrayList<SolidBall> balls) {
        double dx = 10 * vx;
        double dy = 10 * vy;

        x -= dx;
        y -= dy;

        int xc = x + 15;
        int yc = y + 15;

        for (int i = 0; i < balls.size(); i++) {
            int delx = xc - balls.get(i).x - 15;
            int dely = yc - balls.get(i).y - 15;

            if (Math.hypot(delx, dely) <= 30) {
                double angle = Math.atan2(dely, delx);
                balls.get(i).vx = Math.cos(angle);
                balls.get(i).vy = Math.sin(angle);
                vx = 0;
                vy = 0;
            }
        }
    }
}
