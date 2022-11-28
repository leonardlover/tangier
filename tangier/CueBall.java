package tangier;
import java.awt.Color;
import java.awt.Graphics;

class CueBall extends Ball {
    public int x;
    public int y;

    public CueBall() {
        super();
        x = 300;
        y = 300;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.black);
        g.drawOval(x, y, 30, 30);
    }
}
