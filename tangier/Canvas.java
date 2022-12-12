package tangier;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

class Canvas extends JPanel implements MouseMotionListener, MouseListener, ActionListener {
    private Table table;
    private Rack rack;
    private Ball cueball;
    private Player player1;
    private Player player2;
    private int turn;
    private int ticks;
    private int mx;
    private int my;

    public Canvas() {
        super();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        table = new Table();
        rack = new Rack();
        cueball = rack.getCueBall();
        player1 = new Player();
        player2 = new Player();

        turn = 0;
        ticks = 0;

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
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
        if (turn == 0) {
            turn = 1;
        }
        else if (!cueball.isMoving()) {
            if (turn == 1) {
                rack.hitWithCue(player1.getCue());
                ticks = 0;
                turn = 2;
            }
            else if (turn == 2) {
                rack.hitWithCue(player2.getCue());
                ticks = 0;
                turn = 1;
            }
        }
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
        rack.move(ticks, player1, player2);
        ticks++;
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        table.paintComponent(g);
        rack.paintComponent(g);
        player1.paintComponent(g, cueball, mx, my, (turn == 1));
        player2.paintComponent(g, cueball, mx, my, (turn == 2));

        if (turn == 0) {
            g.drawString("Click to begin", 450, 30);
        }
        else {
            g.drawString("Turn: Player " + turn, 450, 30);
        }
    }
}
