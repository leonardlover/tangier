package tangier;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

import java.awt.*;
import javax.swing.*;

class Canvas extends JPanel implements MouseMotionListener, MouseListener, ActionListener {
    private Random rand;
    private Table table;
    private CueBall cueball;
    private ArrayList<SolidBall> solidBall;
    private ArrayList<StripedBall> stripedBall;
    private Player player;
    private SolidBall redSolid, orangeSolid, yellowSolid, greenSolid, blueSolid, purpleSolid, brownSolid;
    private StripedBall redStriped, orangeStriped, yellowStriped, greenStriped, blueStriped, purpleStriped, brownStriped;
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
        
        this.yellowSolid = new SolidBall(Color.yellow, "1");
        this.blueSolid = new SolidBall(Color.blue, "2");
        this.redSolid = new SolidBall(Color.red, "3");
        this.purpleSolid = new SolidBall(new Color(0x9F2B68), "4");
        this.orangeSolid = new SolidBall(Color.orange,"5");
        this.greenSolid = new SolidBall(Color.green, "6");
        this.brownSolid = new SolidBall(new Color(0x4B371C),"7");

        this.yellowStriped = new StripedBall(Color.yellow, "9");
        this.blueStriped = new StripedBall(Color.blue, "10");
        this.redStriped = new StripedBall(Color.red, "11");
        this.purpleStriped = new StripedBall(new Color(0x9F2B68), "12");
        this.orangeStriped = new StripedBall(Color.orange, "13");
        this.greenStriped = new StripedBall(Color.green, "14");
        this.brownStriped = new StripedBall(new Color(0x4B371C), "15");

        this.solidBall = new ArrayList<SolidBall>();
        this.solidBall.add(yellowSolid); this.solidBall.add(blueSolid); this.solidBall.add(redSolid); this.solidBall.add(purpleSolid); this.solidBall.add(orangeSolid); this.solidBall.add(greenSolid); this.solidBall.add(brownSolid);
        this.stripedBall = new ArrayList<StripedBall>();
        this.stripedBall.add(yellowStriped); this.stripedBall.add(blueStriped); this.stripedBall.add(redStriped); this.stripedBall.add(purpleStriped); this.stripedBall.add(orangeStriped); this.stripedBall.add(greenStriped); this.stripedBall.add(brownStriped);
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
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                if((this.stripedBall.get(i).x > this.stripedBall.get(j).x && stripedBall.get(i).x < stripedBall.get(j).x+30) ||  (this.stripedBall.get(i).x > this.solidBall.get(j).x && stripedBall.get(i).x < solidBall.get(j).x+30)) {
                    this.stripedBall.get(i).setX(rand.nextInt(700)+100);
                }
                
                if((stripedBall.get(i).y > stripedBall.get(j).y && stripedBall.get(i).y < stripedBall.get(j).y+30) || (stripedBall.get(i).y > solidBall.get(j).y&& stripedBall.get(i).y < solidBall.get(j).y+30)) {     
                    this.stripedBall.get(i).setY(rand.nextInt(500)+100);
                }
            }
        }
        for(int i = 0; i < 7; i++) {
            this.solidBall.get(i).paintComponent(g);
        }
        for(int i = 0; i < 7; i++) {
            this.stripedBall.get(i).paintComponent(g);
        }
        cueball.paintComponent(g);
        player.paintComponent(g, this.cueball, mx, my);
    }
}
