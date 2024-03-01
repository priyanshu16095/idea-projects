import javax.swing.*;

public class mainFrame extends JFrame {
    public static void main(String[] args) {
        new mainFrame();
    }
    public mainFrame() {
        this.setTitle("Main Frame");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new mainPanel());

        this.setVisible(true);
    }
}
