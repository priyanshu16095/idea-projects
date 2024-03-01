package JComponents;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    public MyTextField(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setFont(new Font("Consolas", Font.BOLD, 20));
    }
    public static void main(String[] args) {
        MyCentreFrame frame = new MyCentreFrame(400, 400, "Frame");
        MyTextField name = new MyTextField(0, 0, 300, 50);
        frame.add(name);
    }
}
