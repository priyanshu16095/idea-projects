import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {
    public static void main(String[] args) {
        new MyFrame();
    }

    JLabel label;
    MyFrame() {
        this.setTitle("Key Listener");
        this.setBounds(0, 0, 400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);

        label = new JLabel();
        label.setBackground(Color.RED);
        label.setBounds(0, 0, 40, 100);
        label.setOpaque(true);

        this.add(label);
        this.setLayout(null);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'a':
                label.setLocation(label.getX()-15, label.getY());
                break;
            case 'd':
                label.setLocation(label.getX()+15, label.getY());
                break;
            case 'w':
                label.setLocation(label.getX(), label.getY()-15);
                break;
            case 's':
                label.setLocation(label.getX(), label.getY()+15);
                break;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // CALLED WHENEVER A BUTTON IS RELEASED
        System.out.println("You released a key char : " + e.getKeyChar());
    }

}
