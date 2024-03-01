import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class homepage {
    public static void main(String[] args) throws IOException {
        new homepage();
    }
    public homepage() throws IOException {
        JFrame frame = new JFrame();
        frame.setTitle("Student Management System");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(0, 0, 700, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 200, 500);
        panel.setBackground(Color.lightGray);

        JButton addButton = new JButton();
        addButton.setBounds(10, 20, 180, 30);
        addButton.setFont(new Font("Consolas", Font.BOLD, 20));
        addButton.setFocusable(false);
        addButton.setText("Add");
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new add();
            }
        });

        JButton viewButton = new JButton();
        viewButton.setBounds(10, 55, 180, 30);
        viewButton.setFont(new Font("Consolas", Font.BOLD, 20));
        viewButton.setFocusable(false);
        viewButton.setText("View");
        viewButton.setBackground(Color.black);
        viewButton.setForeground(Color.WHITE);
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new view();
            }
        });

        JButton updateButton = new JButton();
        updateButton.setBounds(10, 90, 180, 30);
        updateButton.setFont(new Font("Consolas", Font.BOLD, 20));
        updateButton.setFocusable(false);
        updateButton.setText("Update");
        updateButton.setBackground(Color.black);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new view();
            }
        });

        JButton removeButton = new JButton();
        removeButton.setBounds(10, 125, 180, 30);
        removeButton.setFont(new Font("Consolas", Font.BOLD, 20));
        removeButton.setFocusable(false);
        removeButton.setText("Remove");
        removeButton.setBackground(Color.black);
        removeButton.setForeground(Color.WHITE);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new removePass();
            }
        });

        JButton termsButton = new JButton();
        termsButton.setBounds(10, 355, 180, 30);
        termsButton.setFont(new Font("Consolas", Font.BOLD, 20));
        termsButton.setFocusable(false);
        termsButton.setText("Terms");
        termsButton.setBackground(Color.black);
        termsButton.setForeground(Color.WHITE);
        termsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new terms();
            }
        });

        JButton aboutButton = new JButton();
        aboutButton.setBounds(10, 390, 180, 30);
        aboutButton.setFont(new Font("Consolas", Font.BOLD, 20));
        aboutButton.setFocusable(false);
        aboutButton.setText("About");
        aboutButton.setBackground(Color.black);
        aboutButton.setForeground(Color.WHITE);
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new about();
            }
        });

        panel.add(addButton);
        panel.add(viewButton);
        panel.add(updateButton);
        panel.add(removeButton);
        panel.add(termsButton);
        panel.add(aboutButton);
        panel.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu option = new JMenu("Options");
        JMenuItem addItem = new JMenuItem("Add");
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new add();
            }
        });
        JMenuItem viewItem = new JMenuItem("View");
        viewItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new remove();
            }
        });
        JMenuItem updateItem = new JMenuItem("Update");
        updateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view();
            }
        });
        JMenuItem removeItem = new JMenuItem("Remove");
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new removePass();
            }
        });

        JMenu more = new JMenu("More");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new about();
            }
        });
        JMenuItem lockItem = new JMenuItem("Log out");
        lockItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new index();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.dispose();
            }
        });
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel sms = new JLabel();
        sms.setText("Student Management System");
        sms.setFont(new Font("Consolas", Font.BOLD, 25));
        sms.setBounds(300, 380, 400, 30);
        JLabel imgLabel = new JLabel();
        imgLabel.setBounds(270, 40, 350, 350);
        BufferedImage bufferedImage = ImageIO.read(new File("src/img/homepageLogo.png"));
        Image image = bufferedImage.getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        imgLabel.setIcon(icon);
        frame.add(imgLabel);

        more.add(aboutItem);
        more.add(exitItem);
        option.add(addItem);
        option.add(viewItem);
        option.add(updateItem);
        option.add(removeItem);
        menuBar.add(option);
        option.add(lockItem);
        menuBar.add(more);

        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
