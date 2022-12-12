package tangier;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/** The game's Table.
 *  @author leo
 * */
class Table extends JPanel {
    public Table() {
        super();
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(105, 69, 12));
        g.fillRect(70, 70, 860, 660);
        g.setColor(new Color(17, 130, 73));
        g.fillRect(100, 100, 800, 600);
        g.setColor(Color.black);
        g.drawRect(70, 70, 860, 660);
        g.drawRect(100, 100, 800, 600);

        g.fillOval(75, 75, 50, 50);
        g.fillOval(475, 75, 50, 50);
        g.fillOval(875, 75, 50, 50);
        g.fillOval(75, 675, 50, 50);
        g.fillOval(475, 675, 50, 50);
        g.fillOval(875, 675, 50, 50);
    }
}
