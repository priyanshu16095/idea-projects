import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int PANEL_WIDTH = 600;
    static final int PANEL_HEIGHT = PANEL_WIDTH;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (PANEL_WIDTH * PANEL_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int appleEaten;
    int appleX;
    int appleY;
    char direction = 'D';
    boolean running;
    Timer timer;
    Random random;

    public GamePanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        random = new Random();
        startGame();
    }
    public void startGame() {
        newApple();
        running = true;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        for(int i = 0; i < PANEL_HEIGHT/UNIT_SIZE; i++) {
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, PANEL_HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, PANEL_WIDTH, i*UNIT_SIZE);
        }
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        for(int i = 0; i < bodyParts; i++) {
            g.setColor(Color.green);
            g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
        }
    }
    public void newApple() {
        appleX = random.nextInt((int) PANEL_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt((int) PANEL_WIDTH/UNIT_SIZE)*UNIT_SIZE;
    }
    public void move() {
        for(int i = bodyParts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch(direction) {
            case'W':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'S':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'A':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'D':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    public void checkApple() {

    }
    public void checkCollisions() {
        for(int i = bodyParts; i > 0; i--) {
           if(x[0] == x[i] && y[0] == y[i]) {
               running = false;
           }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    }

}
