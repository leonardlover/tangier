package tangier;
import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;

class SolidBall extends Ball {
    
    public SolidBall(Color color, String number) {
        super(color, number, 0, 0);
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.white);
        g.fillOval(x+8, y+8, 14, 14);
        g.setColor(Color.black);
        g.drawOval(x, y, 30, 30);   
        g.drawString(number, x+12, y+20);   
    }
}