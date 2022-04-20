import javax.swing.*;
import java.awt.*;

public class Main extends JPanel{
    public static void main(String[] args) {
        // Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Set up main window (using Swing's Jframe)
                JFrame frame = new JFrame("Ping_Pong");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.requestFocusInWindow();

                frame.setContentPane(new Ball());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
