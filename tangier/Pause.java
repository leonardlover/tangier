package tangier;
import java.awt.*;
import javax.swing.JPanel;

class Pause extends JPanel {
    public Rectangle resumeButton;
    public Rectangle mainMenuButton;
    public Rectangle quitButton;
    
    public Pause() {
        super();
        resumeButton = new Rectangle(430, 250, 150, 50);
        mainMenuButton = new Rectangle(430, 350, 150, 50); 
        quitButton = new Rectangle(430, 450, 150, 50);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(new Color(0,0,0,100));
        g.fillRect(0,0,1000,800);

        Font f0 = new Font("arial", Font.BOLD, 30);
        g.setFont(f0);
        g.setColor(Color.black);
        g.drawString("Pause", 200, 150);

        g.setColor(Color.white);
        g.fillRect(430, 250, 150, 50);
        g.fillRect(430, 350, 150, 50); 
        g.fillRect(430, 450, 150, 50);

        Font f1 = new Font("arial", Font.PLAIN, 20);
        g.setFont(f1);
        g.setColor(Color.black);

        g.drawString("Resume", resumeButton.x+30, resumeButton.y+35);
        g.drawString("Main Menu", mainMenuButton.x+10, mainMenuButton.y+35);
        g.drawString("Quit", quitButton.x+30, quitButton.y+35);
    }
}