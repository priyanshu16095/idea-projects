import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Panel extends JPanel {
    Color babyBlue = Color.decode("#BFD7ED");
    Color blueGrotto = Color.decode("#60A3D9");
    Color royalBlue = Color.decode("#0074B7");
    Color navyBlue = Color.decode("#003B73");
    static final int WIDTH = 320;
    static final int HEIGHT = 490;
    JTextField msgField;
    JButton sendButton;
    JLabel nameLabel;
    JLabel onlineLabel;
    JLabel imgLabel;
    JPanel topPanel;
    JPanel bottomPanel;
    String name;
    Image image;
    static Box verticalBox;
    public Panel(String name) {
        this.name = name;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.setBackground(babyBlue);

        // ----------------------------------------------------------
        topPanel = new JPanel();
        topPanel.setBackground(royalBlue);
        topPanel.setBounds(0, 0, WIDTH, 55);
        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 23));
        nameLabel.setText(name);
        nameLabel.setBounds(44, 14, 200, 23);
        nameLabel.setForeground(Color.WHITE);

        imgLabel = new JLabel();
        imgLabel.setBounds(5, 7, 40, 40);
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("src/img/avatar.png"));
            image = bufferedImage.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(image);
        imgLabel.setIcon(icon);
        topPanel.add(imgLabel);

        topPanel.add(nameLabel);
        onlineLabel = new JLabel();
        onlineLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        onlineLabel.setText("Online");
        onlineLabel.setBounds(46, 32, 200, 23);
        onlineLabel.setForeground(Color.WHITE);
        topPanel.add(onlineLabel);
        topPanel.setLayout(null);
        this.add(topPanel);
        // ----------------------------------------------------------

        bottomPanel = new JPanel();
        bottomPanel.setBackground(blueGrotto);
        bottomPanel.setBounds(0, HEIGHT-50, WIDTH, 50);
        msgField = new JTextField();
        msgField.setBounds(5, 10, 220, 30);
        msgField.setFont(new Font("Consolas", Font.BOLD, 22));
        bottomPanel.add(msgField);
        sendButton = new JButton();
        sendButton.setBounds(230, 10, 85, 30);
        sendButton.setText("Send");
        sendButton.setBackground(royalBlue);
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Consolas", Font.BOLD, 23));
        sendButton.setFocusable(false);
        bottomPanel.add(sendButton);
        bottomPanel.setLayout(null);
        this.add(bottomPanel);

        JPanel msgPanel = new JPanel();
        msgPanel.setBackground(babyBlue);
        msgPanel.setBounds(0, 55, WIDTH, HEIGHT);
        this.add(msgPanel);
        verticalBox = Box.createVerticalBox();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = msgField.getText();

                JLabel msgLabel = new JLabel(msg);
                JPanel outPanel = formatLabel(msg);

                msgPanel.setLayout(new BorderLayout());

                JPanel rightPanel = new JPanel(new BorderLayout());
                rightPanel.setBackground(babyBlue);
                rightPanel.add(outPanel, BorderLayout.LINE_END);
                verticalBox.add(rightPanel);
                verticalBox.add(Box.createVerticalStrut(5));
                msgPanel.add(verticalBox, BorderLayout.PAGE_START);
                repaint();
                invalidate();
                validate();
            }
            public static JPanel formatLabel(String out) {
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                JLabel output = new JLabel(out);
                output.setFont(new Font("Consolas", Font.BOLD, 18));
                output.setForeground(Color.white);
                output.setBackground(Color.decode("#003B73"));
                output.setOpaque(true);
                output.setBorder(new EmptyBorder(5, 10, 2, 30));
                panel.add(output);
                return panel;
            }
        });

        this.setLayout(null);
    }
}
