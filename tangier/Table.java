package tangier;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Table extends JPanel {
    public Table() {
    }
        super();
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(17, 130, 73));
        g.fillRect(100, 100, 800, 600);
    }
}
