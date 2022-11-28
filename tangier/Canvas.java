package tangier;
import java.awt.Graphics;
import javax.swing.JPanel;

class Canvas extends JPanel {
    private Table table;
    private CueBall cueball;
    Player player;

    public Canvas() {
        super();
        this.table = new Table();
        this.cueball = new CueBall();
        this.player = new Player();
    }

    public void paintComponent(Graphics g) {
        table.paintComponent(g);
        cueball.paintComponent(g);
        player.paintComponent(g);
    }
}
