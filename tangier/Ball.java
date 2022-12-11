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

    public void move(ArrayList<SolidBall> solid, ArrayList<StripedBall> striped) {
        double dx = 10 * vx;
        double dy = 10 * vy;

        if (x - dx >= 100 && x - dx <= 870) {
            x -= dx;
        }
        else {
            isMoving = false;
        }

        if (y - dy >= 100 && y - dy <= 670) {
            y -= dy;
        }
        else {
            isMoving = false;
        }

        int xc = x + 15;
        int yc = y + 15;

        for (int i = 0; i < solid.size(); i++) {
            int delx = xc - solid.get(i).x - 15;
            int dely = yc - solid.get(i).y - 15;

            if (Math.hypot(delx, dely) <= 30 && number != solid.get(i).number) {
                double angle = Math.atan2(dely, delx);
                solid.get(i).vx = Math.cos(angle);
                solid.get(i).vy = Math.sin(angle);
                vx = 0;
                vy = 0;
                isMoving = false;
            }
        }

        for (int i = 0; i < striped.size(); i++) {
            int delx = xc - striped.get(i).x - 15;
            int dely = yc - striped.get(i).y - 15;

            if (Math.hypot(delx, dely) <= 30 && number != striped.get(i).number) {
                double angle = Math.atan2(dely, delx);
                striped.get(i).vx = Math.cos(angle);
                striped.get(i).vy = Math.sin(angle);
                vx = 0;
                vy = 0;
                isMoving = false;
            }
        }
    }
}
