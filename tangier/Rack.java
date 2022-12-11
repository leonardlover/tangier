package tangier;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

class Rack extends JPanel {
    private ArrayList<Ball> rack;

    public Rack() {
        rack = new ArrayList<Ball>();
        Ball b;

        for (int i = 0; i < 16; i++) {
            b = new Ball(i);
            rack.add(b);
        }

        int dx = 31;
        int dy = 20;

        rack.get(0).setPos(300, 400);
        rack.get(9).setPos(600, 400);
        rack.get(12).setPos(600 + dx, 400 - dy);
        rack.get(1).setPos(600 + 2 * dx, 400 - 2 * dy);
        rack.get(14).setPos(600 + 3 * dx, 400 - 3 * dy);
        rack.get(5).setPos(600 + 4 * dx, 400 - 4 * dy);
        rack.get(7).setPos(600 + dx, 400 + dy);
        rack.get(15).setPos(600 + 2 * dx, 400 + 2 * dy);
        rack.get(6).setPos(600 + 3 * dx, 400 + 3 * dy);
        rack.get(11).setPos(600 + 4 * dx, 400 + 4 * dy);
        rack.get(8).setPos(600 + 2 * dx, 400);
        rack.get(3).setPos(600 + 3 * dx, 400 - dy);
        rack.get(10).setPos(600 + 3 * dx, 400 + dy);
        rack.get(4).setPos(600 + 4 * dx, 400 - 2 * dy);
        rack.get(13).setPos(600 + 4 * dx, 400);
        rack.get(2).setPos(600 + 4 * dx, 400 + 2 * dy);
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < rack.size(); i++) {
            rack.get(i).paintComponent(g);
        }
    }
}
