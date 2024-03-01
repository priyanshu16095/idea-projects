import com.toedter.calendar.JDateChooser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;

public class about {
    public static void main(String[] args) {
        new about();
    }
    public about() {
        JFrame frame = new JFrame();
        frame.setTitle("About");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(40, 30, 610, 200);
        frame.setResizable(false);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 60);
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        JLabel infoLabel = new JLabel("About");
        infoLabel.setBounds(250, 16, 280, 40);
        infoLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        infoLabel.setForeground(Color.BLACK);

        JLabel nameLabel = new JLabel("Author: Priyanshu Gupta");
        nameLabel.setBounds(140, 70, 410, 40);
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 25));
        nameLabel.setForeground(Color.BLACK);

        JLabel dateLabel = new JLabel("16-oct-2023");
        dateLabel.setBounds(220, 100, 290, 40);
        dateLabel.setFont(new Font("Consolas", Font.BOLD, 25));
        dateLabel.setForeground(Color.BLACK);

        panel.add(infoLabel);
        frame.add(nameLabel);
        frame.add(dateLabel);
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
