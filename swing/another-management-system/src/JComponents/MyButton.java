package JComponents;
import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(int x, int y, int width, int height, Color color, int fontSize, String text) {
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setFont(new Font("Consolas", Font.BOLD, fontSize));
        this.setFocusable(false);
        this.setBackground(color);
        this.setForeground(Color.WHITE);
    }
}
