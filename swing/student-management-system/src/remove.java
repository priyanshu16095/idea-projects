import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class remove {
    JTable table;
    JComboBox box;
    JLabel name;
    public static void main(String[] args) {
        new remove();
    }
    public remove() {
        JFrame frame = new JFrame();
        frame.setTitle("Remove");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(10, 30, 675, 426);
        frame.setResizable(false);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 675, 100);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        JLabel infoLabel = new JLabel("Student Details");
        infoLabel.setBounds(207, 10, 280, 40);
        infoLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        infoLabel.setForeground(Color.BLACK);

        JButton searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setBackground(Color.lightGray);
        searchButton.setForeground(Color.BLACK);
        searchButton.setFocusable(false);
        searchButton.setFont(new Font("Consolas", Font.BOLD, 22));
        searchButton.setBounds(30, 60, 110, 30);
        panel.add(searchButton);

        box = new JComboBox();
        box.setBounds(140, 60, 150, 30);
        box.setFont(new Font("Consolas", Font.BOLD, 19));
        box.setFocusable(false);
        panel.add(box);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");
            Statement stmt = c.createStatement();
            String query = "select * from stuDetails;";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                String ids = rs.getString("stuID");
                box.addItem(ids);
            }
        } catch(Exception e) {
            System.out.println("Some error occured!");
        }

        JPanel namePanel = new JPanel();
        namePanel.setBackground(Color.darkGray);
        namePanel.setBounds(330, 60, 200, 30);
        name =  new JLabel();
        name.setBounds(200, 60, 200, 30);
        name.setFont(new Font("Consolas", Font.BOLD, 19));
        name.setForeground(Color.white);
        namePanel.add(name);
        frame.add(namePanel);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");
            Statement s = con.createStatement();

            String query = "select name from studetails where stuID='"+(String) box.getSelectedItem()+"';";
            ResultSet rs = s.executeQuery(query);
            while(rs.next()) {
                name.setText(rs.getString("name"));
            }
        } catch(Exception e) {
            System.out.println("Some exception occuired!");
            e.printStackTrace();
        }
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");
                    Statement stmt = c.createStatement();
                    String query = "select name from studetails where stuID='"+(String) box.getSelectedItem()+"';";
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton removeButton = new JButton();
        removeButton.setBounds(540, 60, 110, 30);
        removeButton.setFont(new Font("Consolas", Font.BOLD, 19));
        removeButton.setFocusable(false);
        removeButton.setText("Remove");
        removeButton.setBackground(Color.black);
        removeButton.setForeground(Color.WHITE);
        frame.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = (String) box.getSelectedItem();
                new removeAsk(id);
                frame.dispose();
            }
        });

        table = new JTable();
        table.setFont(new Font("Consolas", Font.PLAIN, 18));
        table.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 22));
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setWidth(30);
//        columnModel.getColumn(1).setWidth(100);
//        columnModel.getColumn(2).setWidth(100);
//        columnModel.getColumn(3).setWidth(100);
//        columnModel.getColumn(4).setWidth(100);
//        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.setLayout(null);
        table.setRowHeight(22);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");

            Statement stmt = c.createStatement();
            String query = "select * from stuDetails;";
            ResultSet rs = stmt.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Some error occured!");
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 660, 426);

        frame.add(scrollPane);
        panel.add(infoLabel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
