package tangier;
import java.awt.*;
import javax.swing.JPanel;

/** Pause menu class.
 * @author clau
 * */
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

        g.setColor(new Color(0,0,0,110));
        g.fillRect(0,0,1000,800);

        g.setColor(new Color(255,255,255,230));
        g.fillRect(355,200,300,360);

        Font f1 = new Font("arial", Font.PLAIN, 25);
        g.setFont(f1);
        g.setColor(Color.black);
        g2d.draw(resumeButton);
        g2d.draw(mainMenuButton);
        g2d.draw(quitButton);

        g.drawString("Resume", resumeButton.x+25, resumeButton.y+35);
        g.drawString("Main Menu", mainMenuButton.x+10, mainMenuButton.y+35);
        g.drawString("Quit", quitButton.x+45, quitButton.y+35);
    }
}
