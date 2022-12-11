package tangier;
import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;

class StripedBall extends Ball {

    public StripedBall(Color color, String number) {
        super(color, number, 0, 0);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x,y,30,30);
        g.setColor(color);
        g.fillRect(x+1,y+6,29,18);
        g.setColor(Color.white);
        g.fillOval(x+8,y+8,14,14);
        g.setColor(Color.black);
        g.drawOval(x,y,30,30);
        g.drawString(number,x+8,y+20);
    }
}
