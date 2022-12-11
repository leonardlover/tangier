package tangier;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
    private Options options;
    private Pause pause;
    
    private int mx;
    private int my;
    public static enum STATE {
        MENU,
        OPTIONS,
        GAME,
        PAUSE
    };
    public static STATE State;

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
        
        State = STATE.MENU;
        menu = new Menu();
        options = new Options();
        pause = new Pause();

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
        
        if(State == STATE.MENU) {
            // Play Button
            if(mx >= 430 && mx <= 580) {
                if(my >= 250 && my <= 300) {
                    State = Canvas.STATE.GAME;
                }
            }
            // Options button
            if(mx >= 430 && mx <= 580) {
                if(my >= 350 && my <= 400)  {
                    State = Canvas.STATE.OPTIONS;
                }
            }
            // Quit Button
            if(mx >= 430 && mx <= 580) {
                if(my >= 450 && my <= 500)  {
                    System.exit(1);
                }
            }  
        } else if(State == STATE.OPTIONS) {
            // Help Button
            if(mx >= 100 && mx <= 300) {
                if(my >= 400 && my <= 450) {
                    System.out.println("HELP");
                    // Abrir ventana explicando el juego
                }
            }
            // Music button
            if(mx >= 100 && mx <= 300) {
                if(my >= 300 && my <= 350)  {
                    System.out.println("MUSIC");
                }
            }
            // Sound Button
            if(mx >= 350 && mx <= 550) {
                if(my >= 300 && my <= 350) {
                    System.out.println("SOUND");
                }
            }
            // Mode button
            if(mx >= 350 && mx <= 550) {
                if(my >= 400 && my <= 450)  {
                    System.out.println("MODE");
                    // Mode += 1; // modo de juego (aleatorio o en triangulo)
                }
            }
            // Done Button
            if(mx >= 100 && mx <= 600) {
                if(my >= 550 && my <= 600)  {
                    System.out.println("DONE");
                }
            }
        } else if(State == STATE.GAME) {
            if(mx >= 20 && mx <= 100) {
                if(my >= 20 && my <= 100) {
                    State = Canvas.STATE.PAUSE;
                }
            }

        } else if(State == STATE.PAUSE) {
            // Resume button
            if(mx >= 430 && mx <= 580) {
                if(my >= 250 && my <= 300) {
                    State = Canvas.STATE.GAME;
                }
            }
            // Main menu button
            if(mx >= 430 && mx <= 580) {
                if(my >= 350 && my <= 400)  {
                    State = Canvas.STATE.MENU;
                }
            }
            // Quit Button
            if(mx >= 430 && mx <= 580) {
                if(my >= 450 && my <= 500)  {
                    System.exit(1);
                }
            } 

        }
        repaint();
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

        if(State == STATE.MENU) {
            menu.paintComponent(g);
        } 
        if(State == STATE.OPTIONS) {
            options.paintComponent(g);
        }
        if(State == STATE.GAME) {
            super.paintComponent(g);
            table.paintComponent(g);
    
            for(int i = 0; i < 7; i++) {
                this.solidBall.get(i).paintComponent(g);
                this.stripedBall.get(i).paintComponent(g);
            }
            cueball.paintComponent(g);
            player.paintComponent(g, this.cueball, mx, my);
        }
        if(State == STATE.PAUSE) {
            super.paintComponent(g);
            table.paintComponent(g);
    
            for(int i = 0; i < 7; i++) {
                this.solidBall.get(i).paintComponent(g);
                this.stripedBall.get(i).paintComponent(g);
            }
            cueball.paintComponent(g);
            player.paintComponent(g, this.cueball, mx, my);

            pause.paintComponent(g);
        }
        
    }
}
