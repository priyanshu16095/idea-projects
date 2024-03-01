package ManagementSystem;

import java.awt.*;
import java.io.IOException;

import JComponents.*;

import javax.swing.*;

public class main {
    public static void main(String[] args) throws IOException {
        final int X = 0;
        final int Y = 0;
        final int FRAME_WIDTH = 700;
        final int FRAME_HEIGHT = 255;
        final int BUTTON_HEIGHT = 30;
        final int BUTTON_WIDTH = 150;
        final int TEXTFIELD_WIDTH = 220;
        final int TEXTFIELD_HEIGHT =30;
        final int NORMAL_FONT_SIZE = 25;
        final int BIG_FONT_SIZE = 28;
        final int TEXTFIELD_FONT_SIZE = 20;
        final int BUTTON_FONT_SIZE = 20;
        
        // -----------------------LOGIN------------------------
        MyCentreFrame loginFrame = new MyCentreFrame(FRAME_WIDTH, FRAME_HEIGHT, "Welcome");
        
        MyPanel panel = new MyPanel(0, 0, 400, 300, Color.LIGHT_GRAY);

        MyLabel loginLabel = new MyLabel(105, 25, 160, 30,  BIG_FONT_SIZE, "Login Page");
        loginLabel.setForeground(Color.black);

        MyLabel nameLabel = new MyLabel(20, 70, 100, 30, NORMAL_FONT_SIZE, "userID");
        MyLabel passLabel = new MyLabel(20, 110, 120, 30, NORMAL_FONT_SIZE, "Password");

        MyButton loginButton = new MyButton(190, 160, 130, 30, Color.BLACK, BUTTON_FONT_SIZE, "Login");

        loginFrame.add(loginLabel);
        loginFrame.add(nameLabel);
        loginFrame.add(passLabel);
        loginFrame.add(loginButton);
        loginFrame.add(panel);
        // ----------------------------------------------------------------------
    }
}
