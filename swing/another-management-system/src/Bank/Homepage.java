package Bank;

import JComponents.MyButton;
import JComponents.MyCentreFrame;
import JComponents.MyLabel;
import JComponents.MyPanel;

import java.awt.*;

public class Homepage {
    final int X = 0;
    final int Y = 0;
    final int HOMEPAGE_WIDTH = 600;
    final int HOMEPAGE_HEIGHT = 400;
    final int BUTTON_HEIGHT = 30;
    final int BUTTON_WIDTH = 150;
    final int TEXTFIELD_WIDTH = 220;
    final int TEXTFIELD_HEIGHT =30;
    final int NORMAL_FONT_SIZE = 25;
    final int SMALL_FONT_SIZE = 20;
    final int BIG_FONT_SIZE = 28;
    final int TEXTFIELD_FONT_SIZE = 20;
    final int BUTTON_FONT_SIZE = 20;
    public Homepage() {
        MyCentreFrame frame = new MyCentreFrame(HOMEPAGE_WIDTH, HOMEPAGE_HEIGHT, "ATM");

        MyLabel chooseLabel = new MyLabel(10, 15 , 300, 40, NORMAL_FONT_SIZE, "Choose a transaction");
        MyLabel descLabel = new MyLabel(10, 45, 500, 30, SMALL_FONT_SIZE, "Press cancel on the digital board to exit.");

        MyPanel panel = new MyPanel(20, 75 , 540, 275, Color.lightGray);

        MyButton signupButton = new MyButton(60, 150, BUTTON_WIDTH, BUTTON_HEIGHT, Color.black, BUTTON_FONT_SIZE,"Sign up");

        frame.add(signupButton);
        frame.add(descLabel);
        frame.add(chooseLabel);
        frame.add(panel);
    }
    public static void main(String[] args) {
        new Homepage();
    }
}
