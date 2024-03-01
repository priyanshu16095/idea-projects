import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        new Server();
        new Client();

//        try{
//            ServerSocket skt = new ServerSocket(6001);
//
//            while(true) {
//                Socket s = skt.accept();
//                DataInputStream din = new DataInputStream(s.getInputStream());
//                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//                while(true) {
//                    String msg = din.readUTF();
//                    Panel panel = formatLabel();
//
//                    JPanel left = new JPanel(new BorderLayout());
//                    left.add(panel, BorderLayout.LINE_START);
//                    verticalBox.add(left);
//                    validate();
//                }
//            }
//        } catch(Exception e){
//            System.out.println("Some exception occured in server!");
//        }
    }

    public static class Server extends JFrame {
        public Server() {
            this.setTitle("Chatting Application");
            try {
                this.add(new Panel("Dogesh"));
            } catch(Exception e) {
                System.out.println();
            }
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.pack();
            this.setLocation(5, 5);
            this.setVisible(true);
        }
    }

    public static class Client extends JFrame {
        public Client() {
            this.setTitle("Chatting Application");
            try {
                this.add(new Panel("Cheems"));
            } catch(Exception e) {
                System.out.println();
            }
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.pack();
            this.setLocation(350, 5);
            this.setVisible(true);
        }
    }

}
