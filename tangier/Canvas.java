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
    private Menu menu;
    
    private int mx;
    private int my;
    public static enum STATE {
        MENU,
        GAME
    };
    public static STATE State = STATE.MENU;

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
        menu = new Menu();
        Timer t = new Timer(16, this);
        t.start();
    }

    public void mouseMoved(MouseEvent me) {
        if(State == STATE.GAME) {
            mx = me.getX();
            my = me.getY();
            this.repaint();
        }
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
        this.player.cue.hitBall(this.cueball);
    }

    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        /*
        playButton = new Rectangle(430, 250, 150, 50);
        optionsButton = new Rectangle(430, 350, 150, 50); 
        quitButton = new Rectangle(430, 450, 150, 50);
         */
        
        // Play Button
        if(mx >= 430 && mx <= 580) {
            if(my >= 250 && my <= 300) {
                //pressed play button
                Canvas.State = Canvas.STATE.GAME;
            }
        }
        // Quit Button
        if(mx >= 430 && mx <= 580) {
            if(my >= 450 && my <= 500)  {
                System.exit(1);
            }
        }
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void actionPerformed(ActionEvent ae) {
        if(State == STATE.GAME) {
            this.cueball.move(solidBall, stripedBall);
            for (int i = 0; i < solidBall.size(); i++) {
                this.solidBall.get(i).move(solidBall, stripedBall);
                this.stripedBall.get(i).move(solidBall, stripedBall);
            }
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(State == STATE.GAME) {
            table.paintComponent(g);
    
            for(int i = 0; i < 7; i++) {
                this.solidBall.get(i).paintComponent(g);
                this.stripedBall.get(i).paintComponent(g);
            }
            cueball.paintComponent(g);
            player.paintComponent(g, this.cueball, mx, my);
        } else if(State == STATE.MENU) {
            menu.paintComponent(g);
        }
    }
}
