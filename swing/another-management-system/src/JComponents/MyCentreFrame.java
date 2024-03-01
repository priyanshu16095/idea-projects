package JComponents;
import javax.swing.*;
import java.awt.*;

public class MyCentreFrame extends JFrame {
    public MyCentreFrame(int width , int height, String title) {
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        // this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
