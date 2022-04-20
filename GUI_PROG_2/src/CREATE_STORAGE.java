import javax.swing.*;
import java.awt.*;

public class CREATE_STORAGE  extends JPanel {
    Storage storage = new Storage();
    CREATE_STORAGE() {
        setMaximumSize(new Dimension(700, 106));
        setBackground(new Color(0x2E3348));
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        Font f1 = new Font("Arial", Font.ITALIC, 15);
        g.setFont(f1);
        String INFO_COUNT_BALLS_HAVE="COUNT OF BALLS IN STORAGE: "+storage.getMap_size();
        String get_count_of_Transport="COUNT OF TRANSPORT CTREATED: "+Transporter.get_count_of_Trans();
        g.drawString(INFO_COUNT_BALLS_HAVE,230,50);
        g.drawString(get_count_of_Transport,230,120);
        repaint();
    }
}
