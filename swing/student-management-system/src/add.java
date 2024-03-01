import com.toedter.calendar.JDateChooser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import javax.swing.*;

public class add {
    String name, fatherName, dob, address, email, stuID;
    public static void main(String[] args) {
        new add();
    }
    public add() {
        JFrame frame = new JFrame();
        frame.setTitle("Add");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(40, 30, 610, 350);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 4400);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        JLabel infoLabel = new JLabel("Student Details");
        infoLabel.setBounds(172, 10, 280, 40);
        infoLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        infoLabel.setForeground(Color.BLACK);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(40, 60, 160, 30);
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 22));

        JTextField nameField = new JTextField();
        nameField.setBounds(220, 60, 320, 30);
        nameField.setFont(new Font("Consolas", Font.BOLD, 22));

        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(40, 100, 160, 30);
        dobLabel.setFont(new Font("Consolas", Font.BOLD, 22));

        JDateChooser dobch =  new JDateChooser();
        dobch.setBounds(220, 100, 320, 30);
        dobch.setFont(new Font("Consolas", Font.BOLD, 20));

        JLabel emailLabel = new JLabel("Email ID");
        emailLabel.setBounds(40, 140, 160, 30);
        emailLabel.setFont(new Font("Consolas", Font.BOLD, 22));

        JTextField emailField = new JTextField();
        emailField.setBounds(220, 140, 320, 30);
        emailField.setFont(new Font("Consolas", Font.BOLD, 22));

        JLabel course = new JLabel();
        course.setText("Choose Course");
        course.setBounds(40, 180, 160, 30);
        course.setFont(new Font("Consolas", Font.BOLD, 22));

        String cou[] = {"", "BSc", "MSc", "BCA", "MCA", "MBA", "B.Tech", "M.Tech"};
        JComboBox box = new JComboBox(cou);
        box.setBounds(220, 180, 320, 30);
        box.setFont(new Font("Consolas", Font.BOLD, 22));
        box.setToolTipText("Choose");

        JLabel stuLabel = new JLabel("StuID");
        stuLabel.setBounds(40, 220, 160, 30);
        stuLabel.setFont(new Font("Consolas", Font.BOLD, 22));

        Random ran = new Random();
        int num = ran.nextInt(999999);
        JLabel stuLable = new JLabel();
        stuLable.setText("" + num);
        stuLable.setBounds(0, 0, 320, 28);
        stuLable.setFont(new Font("Consolas", Font.BOLD, 20));
        stuLable.setForeground(Color.white);
        JPanel stuPanel = new JPanel();
        stuPanel.setBounds(220, 220, 320, 30);
        stuPanel.setBackground(Color.black);
        stuPanel.add(stuLable);

        final JOptionPane pane = new JOptionPane("Student Added Successfully!");
        final JDialog d = pane.createDialog((JFrame)null, "Message");
        d.setLocation(195, 140);

        JButton addButton = new JButton();
        addButton.setBounds(260, 260, 110, 30);
        addButton.setFont(new Font("Consolas", Font.BOLD, 19));
        addButton.setFocusable(false);
        addButton.setText("Add");
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                name = nameField.getText();
                dob = ((JTextField) dobch.getDateEditor().getUiComponent()).getText();
                email = emailField.getText();
                String course = (String) box.getSelectedItem();
                stuID = stuLable.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");
                    Statement stmt = c.createStatement();
                    String query = "insert into stuDetails values('"+name+"', '"+dob+"', '"+email+"', '"+course+"', '"+stuID+"')" ;
                    int i = stmt.executeUpdate(query);
                    d.setVisible(true);
                    frame.dispose();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                ((JTextField)dobch.getDateEditor().getUiComponent()).setText("");
                box.setSelectedIndex(0);
            }
        });

        JButton backButton = new JButton();
        backButton.setBounds(380, 260, 110, 30);
        backButton.setFont(new Font("Consolas", Font.BOLD, 19));
        backButton.setFocusable(false);
        backButton.setText("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JLabel outLabel = new JLabel();
        outLabel.setText("Added successfully!");
        outLabel.setBounds(0, 0, 320, 30);
        outLabel.setFont(new Font("Consolas", Font.BOLD, 22));
        outLabel.setForeground(Color.green);
        JPanel outPanel = new JPanel();
        outPanel.setBounds(180, 350, 360, 30);
        outPanel.setBackground(Color.white);
        outPanel.add(outLabel);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(dobLabel);
        panel.add(dobch);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(course);
        panel.add(box);
        panel.add(stuLabel);
        panel.add(stuPanel);
        panel.add(addButton);
        panel.add(backButton);

        panel.add(infoLabel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
