package ManagementSystem;

import JComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
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
    public Login() {
        MyCentreFrame loginFrame = new MyCentreFrame(FRAME_WIDTH, FRAME_HEIGHT, "Welcome");

        MyPanel panel = new MyPanel(0, 0, 400, 300, Color.LIGHT_GRAY);

        MyLabel loginLabel = new MyLabel(105, 25, 160, 30,  BIG_FONT_SIZE, "Login Page");
        loginLabel.setForeground(Color.black);

        MyLabel nameLabel = new MyLabel(20, 70, 100, 30, NORMAL_FONT_SIZE, "userID");
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 70, 220, 30);
        nameField.setFont(new Font("Consolas", Font.BOLD, 20));

        MyLabel passLabel = new MyLabel(20, 110, 120, 30, NORMAL_FONT_SIZE, "Password");
        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 220, 30);
        passField.setFont(new Font("Consolas", Font.BOLD, 20));

        MyButton loginButton = new MyButton(190, 160, 130, 30, Color.BLACK, BUTTON_FONT_SIZE, "Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText();
                String password = passField.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "ram16095");
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM login where username=? and password=?;");
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();
                } catch(Exception exc) {
                    System.out.println("Some exception occured!");
                }
            }
        });
        loginFrame.add(loginLabel);
        loginFrame.add(nameLabel);
        loginFrame.add(nameField);
        loginFrame.add(passLabel);
        loginFrame.add(passField);
        loginFrame.add(loginButton);
        loginFrame.add(panel);
    }
    public static void main(String[] args) {
        new Login();
    }
}
