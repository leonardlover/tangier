package tangier;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;

class Canvas extends JPanel implements MouseMotionListener {
    private Table table;
    private CueBall cueball;
    private Player player;
    private int mx;
    private int my;

    public Canvas() {
        super();
        this.addMouseMotionListener(this);
        this.table = new Table();
        this.cueball = new CueBall();
        this.player = new Player();
        mx = 0;
        my = 0;

        this.setLayout(null);
        this.setBackground(Color.white);
    }

    public void mouseMoved(MouseEvent me) {
        mx = me.getX();
        my = me.getY();
        this.repaint();
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        table.paintComponent(g);
        cueball.paintComponent(g);
        player.paintComponent(g, this.cueball.x, this.cueball.y, mx, my);
    }
}
