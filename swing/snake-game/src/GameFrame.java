import javax.swing.*;

public class GameFrame extends JFrame {
    public static void main(String[] args) {
        new GameFrame();
    }
    public GameFrame() {
        this.setTitle("Snake Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new GamePanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
