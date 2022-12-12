package tangier;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.Random;

/** This is the main Canvas on the game, it is the main controller.
 *  @author clau
 *  @author leo
 * */

class Canvas extends JPanel implements MouseMotionListener, MouseListener, ActionListener {
    private Random rand;
    private Table table;
    private Rack rack;
    private Ball cueball;
    private Player player1;
    private Player player2;
    private int turn;
    private int ticks;
    private int mx;
    private int my;

    private Menu menu;
    private Options options;
    private Pause pause;

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

        State = STATE.MENU;
        Mode = MODE.PYRAMID;
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
        }
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
        if(State == STATE.GAME) {
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
    }

    public void mousePressed(MouseEvent me) {
        mx = me.getX();
        my = me.getY();
        
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
                    if(Mode == MODE.PYRAMID) {
                        Mode = MODE.RANDOM;
                        options.setMode("Random");
                        rack = new Rack();
                        rack.setBallPos(0,300,400);
                        for(int i = 1; i < 16; i++) {
                            this.rack.setBallPos(i,rand.nextInt(770)+100,rand.nextInt(570)+100);
                        }
                        cueball = rack.getCueBall();
                    } else if(Mode == MODE.RANDOM) {
                        Mode = MODE.PYRAMID;
                        options.setMode("Pyramid");
                        rack = new Rack();
                        cueball = rack.getCueBall();
                    }
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

    /** 60 times a second this function executes, and it
     *  updates the screen.
     * */

    public void actionPerformed(ActionEvent ae) {
        if(State == STATE.GAME) {
            rack.move(ticks, player1, player2);
            ticks++;
            this.repaint();
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
        if(State == STATE.PAUSE) {
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
            g.drawString("This is a two players by turns game. When clicking, the cue hits the white ball.", 100, 250);
            g.drawString("In options->mode, you can choose if balls appear in random or pyramid positions.", 100, 270);
            g.drawString("The player who scores the most wins. Have fun!", 100, 290);

            g.setFont(new Font("arial", Font.PLAIN, 30));
            g2d.draw(new Rectangle(255,600,550,50));
            g.drawString("Done", 255+230, 635);
        }
    }
}
