import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class removeAsk {
//    String id = (String) JComboBox.getSelectedItem();
    String id;
    public removeAsk(String id) {
        this.id = id;
        JFrame frame = new JFrame();
        frame.setTitle("Warning!");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(240, 160, 240, 120);
        frame.setResizable(false);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Delete Student?");
        passwordLabel.setFont(new Font("Consolas", Font.BOLD, 22));
        passwordLabel.setBounds(20, 18, 230, 22);

        JButton yesButton = new JButton();
        yesButton.setBounds(22, 45, 103, 25);
        yesButton.setFont(new Font("Consolas", Font.BOLD, 18));
        yesButton.setFocusable(false);
        yesButton.setText("Delete");
        yesButton.setBackground(Color.black);
        yesButton.setForeground(Color.WHITE);
        final JOptionPane pane = new JOptionPane("Deleted!");
        final JDialog d = pane.createDialog((JFrame)null, "Message");
        d.setLocation(195, 140);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");
                    Statement stmt = c.createStatement();

                    String query = "delete from studetails where stuID='"+id+"'";
                    int rs = stmt.executeUpdate(query);
                    frame.dispose();
                    new remove();
                } catch(Exception ae) {
                    System.out.println("Some exception occured!");
                    ae.printStackTrace();
                }
            }
        });

        JButton noButton = new JButton();
        noButton.setBounds(129, 45, 75, 25);
        noButton.setFont(new Font("Consolas", Font.BOLD, 18));
        noButton.setFocusable(false);
        noButton.setText("No");
        noButton.setBackground(Color.black);
        noButton.setForeground(Color.WHITE);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new remove();
            }
        });

        frame.add(yesButton);
        frame.add(noButton);
        frame.add(passwordLabel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
