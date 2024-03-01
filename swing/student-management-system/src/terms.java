import javax.swing.*;
import java.awt.*;

public class terms {
    public static void main(String[] args) {
        new terms();
    }
    public terms() {
        JFrame frame = new JFrame();
        frame.setTitle("Terms");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(40, 30, 610, 350);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 610, 60);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        JLabel infoLabel = new JLabel("Terms");
        infoLabel.setBounds(250, 16, 200, 35);
        infoLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        infoLabel.setForeground(Color.BLACK);
        panel.add(infoLabel);

        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
