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
    private Random rand;
    private Table table;
    private CueBall cueball;
    private ArrayList<SolidBall> solidBall;
    private ArrayList<StripedBall> stripedBall;
    private Color[] color;
    private Player player;
    private int mx;
    private int my;

    public Canvas() {
        super();
        rand = new Random();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.table = new Table();
        this.cueball = new CueBall();
        this.player = new Player();
        this.color = new Color[] {Color.yellow, Color.blue, Color.red, new Color(0x9F2B68), Color.orange, Color.green, new Color(0x4B371C)};
        this.solidBall = new ArrayList<SolidBall>();
        this.stripedBall = new ArrayList<StripedBall>();
        
        for(int i = 0; i < 7; i++) {
            this.solidBall.add(new SolidBall(color[i], String.valueOf(i+1)));
            this.solidBall.get(i).setX(rand.nextInt(770)+100);
            this.solidBall.get(i).setY(rand.nextInt(570)+100);
            
            this.stripedBall.add(new StripedBall(color[i], String.valueOf(i+9)));
            this.stripedBall.get(i).setX(rand.nextInt(770)+100);
            this.stripedBall.get(i).setY(rand.nextInt(570)+100);
        }
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
        this.cueball.move(solidBall, stripedBall);
        for (int i = 0; i < solidBall.size(); i++) {
            this.solidBall.get(i).move(solidBall, stripedBall);
            this.solidBall.get(i).vx *= 0.99;
            this.solidBall.get(i).vy *= 0.99;
            this.stripedBall.get(i).move(solidBall, stripedBall);
            this.stripedBall.get(i).vx *= 0.9;
            this.stripedBall.get(i).vy *= 0.9;
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        table.paintComponent(g);
    
        for(int i = 0; i < 7; i++) {
            this.solidBall.get(i).paintComponent(g);
            this.stripedBall.get(i).paintComponent(g);
        }
        cueball.paintComponent(g);
        player.paintComponent(g, this.cueball, mx, my);
    }
}
