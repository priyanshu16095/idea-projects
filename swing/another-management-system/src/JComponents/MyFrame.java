package JComponents;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(int x, int y, int width , int height, String title) {
        this.setTitle(title);
        this.setBounds(x, y, width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
