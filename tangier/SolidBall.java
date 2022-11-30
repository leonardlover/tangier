package tangier;
import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;

class SolidBall extends Ball {
    public int number;
    public int x;
    public int y;
    public double vx;
    public double vy;
    public Color color;
    public Random rand;
    public boolean isMoving;

    public SolidBall(Color color, int number) {
        super();
        rand = new Random();
        this.color = color;
        this.number = number;
        x = rand.nextInt(700)+100;
        y = rand.nextInt(500)+100;
        vx = 0;
        vy = 0;
        isMoving = false;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,30,30);
        g.setColor(Color.black);
        g.drawOval(x,y,30,30);      
    }
}