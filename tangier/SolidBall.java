package tangier;
import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;

class SolidBall extends Ball {
    public int x;
    public int y;
    public double vx;
    public double vy;
    public Color color;
    public Random rand;
    public boolean isMoving;
    public String number;

    public SolidBall(Color color, String number) {
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,30,30);
        g.setColor(Color.black);
        g.drawOval(x,y,30,30);   
        g.drawString(number,x+12,y+20);   
    }
}