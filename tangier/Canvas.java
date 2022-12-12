package tangier;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.*;
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
        PAUSE,
        HELP
    };
    public static STATE State;
    public static enum MODE {
        RANDOM,
        PYRAMID
    };
    public static MODE Mode;
    public Rectangle helpRect;

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
        Mode = MODE.RANDOM;
        menu = new Menu();
        options = new Options();
        pause = new Pause();
        helpRect = new Rectangle(50,50,900,665);

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
            if(mx >= 360 && mx <= 660) {
                if(my >= 275 && my <= 325) {
                    State = Canvas.STATE.GAME;
                }
            }
            // Options button
            if(mx >= 360 && mx <= 660) {
                if(my >= 375 && my <= 425)  {
                    State = Canvas.STATE.OPTIONS;
                }
            }
            // Quit Button
            if(mx >= 360 && mx <= 660) {
                if(my >= 475 && my <= 525)  {
                    System.exit(1);
                }
            }  
        } else if(State == STATE.OPTIONS) {
            // Help Button
            if(mx >= 225 && mx <= 475) {
                if(my >= 400 && my <= 450) {
                    System.out.println("HELP");
                    State = STATE.HELP;
                }
            }
            // Mode button
            if(mx >= 525 && mx <= 775) {
                if(my >= 400 && my <= 450)  {
                    if(Mode == MODE.RANDOM) {
                        Mode = MODE.PYRAMID;
                        options.setMode("Pyramid");
                    } else if(Mode == MODE.PYRAMID) {
                        Mode = MODE.RANDOM;
                        options.setMode("Random");
                    }
                    System.out.println("MODE: " + options.mode);
                }
            }
            // Done Button
            if(mx >= 225 && mx <= 775) {
                if(my >= 500 && my <= 550)  {
                    State = Canvas.STATE.MENU;
                }
            }
        } else if(State == STATE.HELP) {
            if(mx >= 255 && mx <= 805) {
                if(my >= 600 && my <= 650) {
                    State = STATE.OPTIONS;
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
            g.setFont(new Font("arial", Font.PLAIN, 20));
            g.drawString("PAUSE",20,40);
            table.paintComponent(g);
            g.setFont(new Font("arial",Font.PLAIN, 11));
    
            for(int i = 0; i < 7; i++) {
                this.solidBall.get(i).paintComponent(g);
                this.stripedBall.get(i).paintComponent(g);
            }
            cueball.paintComponent(g);
            player.paintComponent(g, this.cueball, mx, my);
        }
        if(State == STATE.PAUSE) {
            super.paintComponent(g);
            g.setFont(new Font("arial",Font.PLAIN, 11));
            table.paintComponent(g);
            
            for(int i = 0; i < 7; i++) {
                this.solidBall.get(i).paintComponent(g);
                this.stripedBall.get(i).paintComponent(g);
            }
            cueball.paintComponent(g);
            player.paintComponent(g, this.cueball, mx, my);

            pause.paintComponent(g);
        }
        if(State == STATE.HELP) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.draw(helpRect);

            Font f0 = new Font("arial", Font.BOLD, 30);
            g.setFont(f0);
            g.setColor(Color.black);
            g.drawString("Help", 450, 150);
            
            Font f1 = new Font("arial", Font.PLAIN, 18);
            g.setFont(f1);
            g.drawString("This game is made to be played in turns by two players. When clicking, the cue hits the", 100, 250);
            g.drawString("white ball at the angle at which it is located. The player who scores the most wins.", 100, 270);
            g.drawString("Have fun!", 100, 290);
            g.drawString("Made by Leonardo and Claudia", 100, 490);

            g.setFont(new Font("arial", Font.PLAIN, 30));
            g2d.draw(new Rectangle(255,600,550,50));
            g.drawString("Done", 255+230, 635);
        }
        
    }
}
