package tangier;
import java.awt.*;
import javax.swing.JPanel;

class Menu extends JPanel {
    public Rectangle playButton;
    public Rectangle optionsButton; 
    public Rectangle quitButton;
    
    public Menu() {
        super();
        playButton = new Rectangle(360, 275, 300, 50);
        optionsButton = new Rectangle(360, 375, 300, 50); 
        quitButton = new Rectangle(360, 475, 300, 50);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font f0 = new Font("arial", Font.BOLD, 50);
        g.setFont(f0);
        g.setColor(Color.black);
        g.drawString("TANGIER POOL", 300, 150);
    
        Font f1 = new Font("arial", Font.PLAIN, 30);
        g.setFont(f1);
        g.drawString("Play", playButton.x+115, playButton.y+35);
        g2d.draw(playButton);
        g.drawString("Options", optionsButton.x+95, optionsButton.y+35);
        g2d.draw(optionsButton); 
        g.drawString("Quit", quitButton.x+115, quitButton.y+35);
        g2d.draw(quitButton);
    }
}