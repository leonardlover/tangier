package tangier;
import java.awt.*;
import javax.swing.*;

class Window extends JFrame {
    public Window() {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Tangier");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
