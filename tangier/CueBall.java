package tangier;
import java.awt.Color;
import java.awt.Graphics;

class CueBall extends Ball {
    public int x;
    public int y;
    public double vx;
    public double vy;
    public Boolean isMoving;

    public CueBall() {
        super();
        x = 500;
        y = 500;
        vx = 0;
        vy = 0;
        isMoving = false;
    }

    public void move() {
        double dx = 5 * vx;
        double dy = 5 * vy;

        if (x - dx >= 100 && x - dx <= 870 && isMoving) {
            x -= 5 * vx;
        }
        else {
            isMoving = false;
        }

        if (y - dy >= 100 && y - dy <= 670 && isMoving) {
            y -= 5 * vy;
        }
        else {
            isMoving = false;
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.black);
        g.drawOval(x, y, 30, 30);
    }
}
