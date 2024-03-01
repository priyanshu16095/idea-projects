import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removePass {
    String pass;
    public static void main(String[] args) {
        new removePass();
    }
    public removePass() {
        JFrame frame = new JFrame();
        frame.setTitle("Required");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(240, 160, 240, 140);
        frame.setResizable(false);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Consolas", Font.BOLD, 22));
        passwordLabel.setBounds(60, 15, 200, 22);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Consolas", Font.BOLD, 20));
        passwordField.setBounds(20, 41, 180, 22);

        JButton button = new JButton();
        button.setBounds(60, 70, 90, 25);
        button.setFont(new Font("Consolas", Font.BOLD, 18));
        button.setFocusable(false);
        button.setText("Enter");
        button.setBackground(Color.black);
        button.setForeground(Color.WHITE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = "root";
                String getpass = (String) passwordField.getText();
                if(getpass.equals(pass)) {
                    frame.dispose();
                    new remove();
                } else {
                }
            }
        });

        frame.add(button);
        frame.add(passwordField);
        frame.add(passwordLabel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
