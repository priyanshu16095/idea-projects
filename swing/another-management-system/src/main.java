import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    final int BIG_FONT_SIZE = 25;
    final int SMALL_FONT_SIZE = 20;
    final int NORMAL_FONT_SIZE = 22;
    public main() {
        JFrame frame = new JFrame();
        frame.setTitle("Website | Sign up");
        frame.setSize(400, 400);

        JLabel titleLabel = new JLabel();
        titleLabel.setBounds(20, 10, 250, 30);
        titleLabel.setFont(new Font("Consolas", Font.BOLD, BIG_FONT_SIZE));
        titleLabel.setText("Sign up");

        JLabel usernameLabel = new JLabel();
        usernameLabel.setBounds(20, 55, 250, 30);
        usernameLabel.setFont(new Font("Consolas", Font.BOLD, BIG_FONT_SIZE));
        usernameLabel.setText("Username");

        JLabel emailIdLabel = new JLabel();
        emailIdLabel.setBounds(20, 85, 250, 30);
        emailIdLabel.setFont(new Font("Consolas", Font.BOLD, BIG_FONT_SIZE));
        emailIdLabel.setText("Email Id");

        JLabel passwordLabel = new JLabel();
        passwordLabel.setBounds(20, 115, 250, 30);
        passwordLabel.setFont(new Font("Consolas", Font.BOLD, BIG_FONT_SIZE));
        passwordLabel.setText("Password");

        frame.add(titleLabel);
        frame.add(usernameLabel);
        frame.add(emailIdLabel);
        frame.add(passwordLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 55, 220, 28);
        usernameField.setFont(new Font("Consolas", Font.BOLD, BIG_FONT_SIZE));

        JTextField emailIdField = new JTextField();
        emailIdField.setBounds(150, 85, 220, 28);
        emailIdField.setFont(new Font("Consolas", Font.BOLD, BIG_FONT_SIZE));

        frame.add(usernameField);
        frame.add(emailIdField);

        JButton signupButton = new JButton();
        signupButton.setFont(new Font("Consolas", Font.BOLD, NORMAL_FONT_SIZE));
        signupButton.setFocusable(false);
        signupButton.setBounds(170, 150, 150, 30);
        signupButton.setText("Sign up");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String emailId = emailIdField.getText();
                String password =
            }
        });

        frame.add(signupButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}
