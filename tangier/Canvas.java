package tangier;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

class Canvas extends JPanel implements MouseMotionListener, MouseListener, ActionListener {
    private Table table;
    private Rack rack;
    private int mx;
    private int my;

    public Canvas() {
        super();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.table = new Table();
        this.rack = new Rack();
        mx = 0;
        my = 0;

        this.setLayout(null);
        this.setBackground(Color.white);

        Timer t = new Timer(16, this);
        t.start();
    }

    public void mouseMoved(MouseEvent me) {
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
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
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        table.paintComponent(g);
        rack.paintComponent(g);
    }
}
