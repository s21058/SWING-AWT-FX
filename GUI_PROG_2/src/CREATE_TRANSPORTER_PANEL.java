import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CREATE_TRANSPORTER_PANEL extends JPanel {
    Transporter transporter = new Transporter();
    CREATE_TRANSPORTER_PANEL() {

        transporter.start();
        GridLayout layout = new GridLayout(5, 1);
        setLayout(layout);
        setMaximumSize(new Dimension(412, 412));
        setBackground(BallonColor.setNewColor(BallonColor.Electric_Ultramarine));
//        setBackground(new Color(0xF39C63));
        setBackground(BallonColor.setNewColor(BallonColor.Sandy_Brown));
        JButton delete_button = new JButton("DELETE");
        JButton pause_button = new JButton("PAUSE");
        pause_button.setBackground(BallonColor.setNewColor(BallonColor.Up_Maroon));
        pause_button.setForeground(Color.WHITE);
        JButton resume_button = new JButton("RESUME");
        resume_button.setBackground(BallonColor.setNewColor(BallonColor.Linkoln_Green));
        resume_button.setForeground(Color.WHITE);
        JSlider jSlider = new JSlider();
        jSlider.setVisible(false);
        delete_button.setMaximumSize(new Dimension(delete_button.getMinimumSize().width, Integer.MAX_VALUE));
        delete_button.setForeground(Color.WHITE);
        delete_button.setBackground(BallonColor.setNewColor(BallonColor.Midnight_Green));
        // delete_button.setMinimumSize(new Dimension(delete_button.getMinimumSize().width,Integer.MAX_VALUE));
        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transporter.stops();
                Transporter.reduce_Count_of_Trans();
                setVisible(false);
            }
        });
        pause_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transporter.stop_bal();
                transporter.status= Transporter.status_of_transporter.Waiting;
                    updateUI();
            }
        });
        resume_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transporter.run_balloon();
                transporter.status= Transporter.status_of_transporter.Transporter_Resume;
                updateUI();
            }
        });
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        some_magic();
        add(jSlider);
        add(delete_button);
        add(pause_button);
        add(resume_button);
        setRequestFocusEnabled(true);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        Font f1 = new Font("Arial", Font.ITALIC, 13);
        String id_transport="TRANSPORT ID: "+transporter.getIds();
        String status="STATUS: "+transporter.getStatus();
        g.setFont(f1);
        g.drawString(id_transport,30,30);
        g.drawString(status,30,50);
        repaint();
    }
    public void some_magic(){
        JLabel jLabel = new JLabel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        add(jLabel);
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jLabel4);
        add(jLabel5);
        add(jLabel6);
        add(jLabel7);
        add(jLabel8);
        add(jLabel9);
        add(jLabel10);
    }
}
