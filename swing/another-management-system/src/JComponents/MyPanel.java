package JComponents;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel(int x, int y, int width, int height, Color color) {
        this.setBounds(x, y, width, height);
        this.setBackground(color);
        this.setLayout(null);
    }
}
