package tangier;
import java.awt.Color;
import java.awt.Graphics;

class CueBall extends Ball {
    public CueBall() {
        super();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(300, 300, 30, 30);
        g.setColor(Color.black);
        g.drawOval(300, 300, 30, 30);
    }
}
