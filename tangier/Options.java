package tangier;
import java.awt.*;
import javax.swing.JPanel;

class Options extends JPanel {
    public Rectangle helpButton;
    public Rectangle musicButton;
    public Rectangle soundButton;
    public Rectangle modeButton;
    public Rectangle doneButton;
    public String mode;
    
    public Options() {
        super();
        helpButton = new Rectangle(225, 400, 250, 50);
        modeButton = new Rectangle(525, 400, 250, 50);
        doneButton = new Rectangle(225, 500, 550, 50);
        mode = "Random";
    }

    public void setMode(String m) {
        mode = m;
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font f0 = new Font("arial", Font.BOLD, 30);
        g.setFont(f0);
        g.setColor(Color.black);
        g.drawString("Options", 430, 150);
    
        Font f1 = new Font("arial", Font.PLAIN, 30);
        g.setFont(f1);
        g.drawString("Help", helpButton.x+90, helpButton.y+35);
        g2d.draw(helpButton);
        g.drawString("Mode: " + mode, modeButton.x+10, modeButton.y+35);
        g2d.draw(modeButton); 
        g.drawString("Done", doneButton.x+230, doneButton.y+35);
        g2d.draw(doneButton);
    }
}
