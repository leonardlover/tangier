package tangier;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

class Rack extends JPanel {
    private ArrayList<Ball> rack;

    public Rack() {
        rack = new ArrayList<Ball>();
        for (int i = 0; i < 16; i++) {
            Ball b = new Ball(i);
            b.setPos(35 * i, 200);
            rack.add(b);
        }
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < rack.size(); i++) {
            rack.get(i).paintComponent(g);
        }
    }
}
