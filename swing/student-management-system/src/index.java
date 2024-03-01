
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class index {
    public static void main(String[] args) {
        try {
            new index();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public index() throws IOException {
        JFrame frame = new JFrame();
        frame.setTitle("Welcome");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(0, 0, 700, 255);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 300);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        JLabel titLabel = new JLabel("Login Page");
        titLabel.setFont(new Font("Consolas", Font.BOLD, 28));
        titLabel.setForeground(Color.black);
        titLabel.setBackground(Color.black);
        titLabel.setBounds(105, 25, 160, 30);

        JLabel nameLabel = new JLabel("userID");
        nameLabel.setBounds(20, 70, 100, 30);
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 25));

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(20, 110, 120, 30);
        passLabel.setFont(new Font("Consolas", Font.BOLD, 25));

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 70, 220, 30);
        nameField.setFont(new Font("Consolas", Font.BOLD, 20));

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 220, 30);
        passField.setFont(new Font("Consolas", Font.BOLD, 20));

        panel.add(titLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passLabel);
        panel.add(passField);

        JPanel out = new JPanel();
        out.setBounds(400, 188, 300, 30);
        JLabel outLabel = new JLabel();
        outLabel.setBounds(67, 3, 160, 30);
        outLabel.setFont(new Font("Consolas", Font.BOLD, 22));
        outLabel.setForeground(Color.RED);
        out.add(outLabel);
        out.setLayout(null);

        JLabel imgLabel = new JLabel();
        imgLabel.setBounds(445, 10, 200, 200);
        BufferedImage bufferedImage = ImageIO.read(new File("src/img/avatar.png"));
        Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        imgLabel.setIcon(icon);

        JButton loginButton = new JButton();
        loginButton.setBounds(190, 160, 130, 30);
        loginButton.setFont(new Font("Consolas", Font.BOLD, 20));
        loginButton.setFocusable(false);
        loginButton.setText("Login");
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String username =  nameField.getText();
                String password = String.valueOf(passField.getPassword());
               try {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");
                   Statement stmt = c.createStatement();
                   String query = "select * from login where username='"+username+"' and passowrd='"+password+"';";
                   ResultSet rs = stmt.executeQuery(query);
                   if(rs.next()) {
                       new homepage();
                       frame.dispose();
                   } else {
                       outLabel.setText("Login Failed!");
                       nameField.setText("");
                       passField.setText("");
                   }
               } catch(Exception e) {
                   e.printStackTrace();
               }
            }
        });
        frame.add(out);
        frame.add(loginButton);
        frame.add(panel);
        frame.add(imgLabel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
