import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CREATE_FACTORY_PANEL extends JPanel {
    Factory factory = new Factory();
    CREATE_FACTORY_PANEL() {
        factory.start();
        GridLayout layout = new GridLayout(3, 1);
        setLayout(layout);

        setMaximumSize(new Dimension(212, 212));
        JButton delete_button = new JButton("DELETE");
        delete_button.setForeground(Color.WHITE);
        delete_button.setBackground(BallonColor.setNewColor(BallonColor.Midnight_Green));
        delete_button.setMaximumSize(new Dimension(delete_button.getMinimumSize().width,Integer.MAX_VALUE));
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factory.stops();
                setVisible(false);
            }
        });
        JSlider slider = new JSlider(JSlider.HORIZONTAL,100,3000, (int) factory.getTime());
        slider.setMinorTickSpacing(100);
        slider.setMajorTickSpacing(3000);
        slider.setPaintTicks(true);
        slider.setBackground(BallonColor.setNewColor(BallonColor.Sandy_Brown));
        setBackground(BallonColor.setNewColor(BallonColor.Sandy_Brown));
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                factory.setTime(slider.getValue());
//                    factory.set_time_to_sleep();
//                System.out.println(slider.getValue());
            }
        });
        JLabel label =new JLabel();
        add(label);
        add(slider);
        add(delete_button);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String get_count_of_balloons="Count of balloons created: "+factory.getCount_of_ballon();
        String get_id_factory="FACTORY ID: "+factory.getIds();
        Font f1 = new Font("Arial", Font.ITALIC, 13);
        g.setFont(f1);
        g.drawString(get_count_of_balloons,5,20);
        g.drawString(get_id_factory,40,40);
        repaint();
    }
}
