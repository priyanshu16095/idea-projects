import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class view {
    JTable table;
    public static void main(String[] args) {
        new view();
    }
    public view() {
        JFrame frame = new JFrame();
        frame.setTitle("View");
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

        JLabel searchLabel = new JLabel();
        searchLabel.setText("Search");
        searchLabel.setFont(new Font("Consolas", Font.BOLD, 22));
        searchLabel.setBounds(30, 60, 150, 30);
        panel.add(searchLabel);

        JComboBox box = new JComboBox();
        box.setBounds(110, 60, 150, 30);
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

        JButton printButton = new JButton();
        printButton.setBounds(300, 60, 110, 30);
        printButton.setFont(new Font("Consolas", Font.BOLD, 19));
        printButton.setFocusable(false);
        printButton.setText("Print");
        printButton.setBackground(Color.black);
        printButton.setForeground(Color.WHITE);
        frame.add(printButton);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                } catch(Exception a) {
                    a.printStackTrace();
                }

            }
        });

        final JOptionPane pane = new JOptionPane("Updated Successfully!");
        final JDialog d = pane.createDialog((JFrame)null, "Message");
        d.setLocation(195, 140);

        JButton updateButton = new JButton();
        updateButton.setBounds(420, 60, 110, 30);
        updateButton.setFont(new Font("Consolas", Font.BOLD, 19));
        updateButton.setFocusable(false);
        updateButton.setText("Update");
        updateButton.setBackground(Color.black);
        updateButton.setForeground(Color.WHITE);
        frame.add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new update((String) box.getSelectedItem());
            }
        });

        JButton searchButton = new JButton();
        searchButton.setBounds(540, 60, 110, 30);
        searchButton.setFont(new Font("Consolas", Font.BOLD, 19));
        searchButton.setFocusable(false);
        searchButton.setText("Search");
        searchButton.setBackground(Color.black);
        searchButton.setForeground(Color.WHITE);
        frame.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ram16095");
                    Statement stmt = c.createStatement();

                    String query = "select * from studetails where stuID='"+(String) box.getSelectedItem()+"'";
                    ResultSet rst = stmt.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rst));
                } catch(Exception ae) {
                    System.out.println("Some exceptionnnn occured!");
                }
            }
        });

        table = new JTable();
        table.setFont(new Font("Consolas", Font.PLAIN, 18));
        table.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 22));
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setWidth(5);
//        columnModel.getColumn(1).setWidth(10);
//        columnModel.getColumn(2).setWidth(10);
//        columnModel.getColumn(3).setWidth(10);
//        columnModel.getColumn(4).setWidth(10);
//        table.getTableHeader().getColumnModel().getColumn(4).setWidth(2);


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
