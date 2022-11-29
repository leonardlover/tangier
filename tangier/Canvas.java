package tangier;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;

import java.awt.*;
import javax.swing.*;

class Canvas extends JPanel implements MouseMotionListener, MouseListener, ActionListener {
    private Table table;
    private CueBall cueball;
    private Player player;
    private int mx;
    private int my;

    public Canvas() {
        super();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.table = new Table();
        this.cueball = new CueBall();
        this.player = new Player();
        mx = 0;
        my = 0;

        this.setLayout(null);
        this.setBackground(Color.white);

        Timer t = new Timer(16, this);
        t.start();
    }

    public void mouseMoved(MouseEvent me) {
        mx = me.getX();
        my = me.getY();
        this.repaint();
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
        this.player.cue.hitBall(this.cueball);
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void actionPerformed(ActionEvent ae) {
        this.cueball.move();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        table.paintComponent(g);
        cueball.paintComponent(g);
        player.paintComponent(g, this.cueball, mx, my);
    }
}
