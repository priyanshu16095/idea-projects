package Bank;

import JComponents.MyButton;
import JComponents.MyCentreFrame;
import JComponents.MyLabel;
import JComponents.MyPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    final int FRAME_WIDTH = 450;
    final int FRAME_HEIGHT = 300;
    final int NORMAL_FONT_SIZE = 25;
    final int SMALL_FONT_SIZE = 20;
    final int BIG_FONT_SIZE = 28;
    final int BUTTON_FONT_SIZE = 20;
    final int BUTTON_HEIGHT = 30;
    final int BUTTON_WIDTH = 150;
    public Login() {
        MyCentreFrame frame = new MyCentreFrame(FRAME_WIDTH, FRAME_HEIGHT, "Welcome");

        MyPanel panel = new MyPanel(0, 0, FRAME_WIDTH, 60, Color.LIGHT_GRAY);

        MyLabel welcomeLabel = new MyLabel(120, 10, 300, 50, BIG_FONT_SIZE, "Welcome to ATM");
        welcomeLabel.setForeground(Color.black);

        MyLabel cardnoLabel = new MyLabel(60, 60, 200, 50, NORMAL_FONT_SIZE, "Card No");

        MyLabel pinLabel = new MyLabel(60, 100, 200, 50, NORMAL_FONT_SIZE, "Pin");

        MyButton signupButton = new MyButton(60, 150, BUTTON_WIDTH, BUTTON_HEIGHT, Color.black, BUTTON_FONT_SIZE,"Sign up");
        MyButton clearButton = new MyButton(220, 150, BUTTON_WIDTH, BUTTON_HEIGHT, Color.black, BUTTON_FONT_SIZE,"Clear");
        MyButton signinButton = new MyButton(140, 190, BUTTON_WIDTH, BUTTON_HEIGHT, Color.black, BUTTON_FONT_SIZE,"Sign in");
        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Homepage();
            }
        });

        MyPanel bottomPanel = new MyPanel(0, 230, FRAME_WIDTH, 40, Color.LIGHT_GRAY);

        frame.add(welcomeLabel);
        frame.add(cardnoLabel);
        frame.add(pinLabel);
        frame.add(signupButton);
        frame.add(clearButton);
        frame.add(signinButton);
        frame.add(panel);
        frame.add(bottomPanel);
    }
}
