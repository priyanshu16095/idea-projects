package JComponents;
import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel(int x, int y, int width, int height, int fontSize, String text) {
        this.setBounds(x, y, width, height);
        this.setFont(new Font("Consolas", Font.BOLD, fontSize));
        this.setText(text);
    }
}
