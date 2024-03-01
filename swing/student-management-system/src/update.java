import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class update {
    String name, dob, email, stuID;
    String stuid;
    public static void main(String[] args) {
    }
    public update(String stuid) {
        this.stuid = stuid;
        JFrame frame = new JFrame();
        frame.setTitle("Update");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(40, 30, 610, 350);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 4400);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        JLabel infoLabel = new JLabel("Update Details");
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
        frame.add(dobch);

//        JPanel dobchPanel = new JPanel();
//        dobchPanel.setBackground(Color.black);
//        dobchPanel.setBounds(220, 100, 320, 30);
//        JLabel dobch =  new JLabel();
//        dobch.setText("Can't be changed");
//        dobch.setBounds(0, 0, 320, 30);
//        dobch.setFont(new Font("Consolas", Font.BOLD, 20));
//        dobch.setForeground(Color.white);
//        dobchPanel.add(dobch);
//        frame.add(dobchPanel);

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

        JLabel stuLable = new JLabel();
        stuLable.setText("" + stuid);
        stuLable.setBounds(0, 0, 320, 28);
        stuLable.setFont(new Font("Consolas", Font.BOLD, 20));
        stuLable.setForeground(Color.white);
        JPanel stuPanel = new JPanel();
        stuPanel.setBounds(220, 220, 320, 30);
        stuPanel.setBackground(Color.black);
        stuPanel.add(stuLable);

        final JOptionPane pane = new JOptionPane("Updated Successfully!");
        final JDialog d = pane.createDialog((JFrame)null, "Message");
        d.setLocation(195, 140);

        JButton updateButton = new JButton();
        updateButton.setBounds(260, 260, 110, 30);
        updateButton.setFont(new Font("Consolas", Font.BOLD, 19));
        updateButton.setFocusable(false);
        updateButton.setText("Update");
        updateButton.setBackground(Color.black);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(new ActionListener() {
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
                    String query = "update stuDetails set name='"+name+"', dob='"+dob+"', emailID='"+email+"', course='"+course+"' where stuID='"+stuid+"';";
                    int i = stmt.executeUpdate(query);
                    d.setVisible(true);
                    new view();
                    frame.dispose();
                } catch(Exception e) {
                    e.printStackTrace();
                }
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
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(course);
        panel.add(box);
        panel.add(stuLabel);
        panel.add(stuPanel);
        panel.add(updateButton);
        panel.add(backButton);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");
            Statement s = c.createStatement();

            String query = "select * from studetails where stuID='"+stuid+"';";
            ResultSet rs = s.executeQuery(query);
            while(rs.next()) {
                nameField.setText(rs.getString("name"));
//                String date = ((JTextField) dobch.getDateEditor().getUiComponent()).getText();
                emailField.setText(rs.getString("emailID"));
                box.setSelectedItem(rs.getString("course"));
            }

        } catch(Exception c) {
            System.out.println("Some exception occured!");
        }

        panel.add(infoLabel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
