package tangier;
import java.awt.*;
import javax.swing.JPanel;

class Options extends JPanel {
    public Rectangle helpButton;
    public Rectangle musicButton;
    public Rectangle soundButton;
    public Rectangle modeButton;
    public Rectangle doneButton;
    
    public Options() {
        super();
        helpButton = new Rectangle(100, 400, 200, 50);
        musicButton = new Rectangle(100, 300, 200, 50);
        soundButton = new Rectangle(350, 300, 200, 50);
        modeButton = new Rectangle(350, 400, 200, 50);
        doneButton = new Rectangle(100, 550, 500, 50);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font f0 = new Font("arial", Font.BOLD, 30);
        g.setFont(f0);
        g.setColor(Color.black);
        g.drawString("Options", 200, 150);
    
        Font f1 = new Font("arial", Font.PLAIN, 30);
        g.setFont(f1);
        g.drawString("Help", helpButton.x+30, helpButton.y+35);
        g2d.draw(helpButton);
        g.drawString("Music", musicButton.x+10, musicButton.y+35);
        g2d.draw(musicButton); 
        g.drawString("Sound", soundButton.x+30, soundButton.y+35);
        g2d.draw(soundButton);
        g.drawString("Mode", modeButton.x+10, modeButton.y+35);
        g2d.draw(modeButton); 
        g.drawString("Done", doneButton.x+30, doneButton.y+35);
        g2d.draw(doneButton);
    }
}
