import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.LabelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Field extends JFrame {
  static   JPanel panel = new JPanel();
    Balloon_Droping_anim balloon_droping_anim = new Balloon_Droping_anim();
    Field() {
        JPanel jPanel = new JPanel(); // Main panel
        JLayeredPane jLayeredPane = new JLayeredPane();
        jLayeredPane.setLayout(null);

        JPanel panel_Factory = new JPanel();
        panel_Factory.setBackground(BallonColor.setNewColor(BallonColor.Glitter));
        JPanel panel_Transport = new JPanel();
        panel_Transport.setBackground(BallonColor.setNewColor(BallonColor.Glitter));
//        panel_Transport.setBackground(BallonColor.setNewColor(BallonColor.getRandom_Color()));
        JPanel panel_Storage = new JPanel();
        GridLayout layout = new GridLayout(5, 1);
        jPanel.setLayout(layout);

        JScrollPane jScrollPane_Factory = new JScrollPane(panel_Factory);
        jScrollPane_Factory.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane_Factory.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JScrollPane jScrollPane_Transporter = new JScrollPane(panel_Transport);
        jScrollPane_Transporter.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane_Transporter.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

//        BoxLayout boxLayout = new BoxLayout(panel_Factory, BoxLayout.X_AXIS);
        FlowLayout flowLayout = new FlowLayout();
//        flowLayout.set
        panel_Factory.setLayout(flowLayout);
        panel_Factory.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JButton add_factory = new JButton("ADD FACTORY");
        add_factory.setBackground(BallonColor.setNewColor(BallonColor.Sandy_Brown));
        add_factory.setFont(new Font("Arial", Font.ITALIC, 15));
        //add_factory.setMaximumSize(new Dimension(add_factory.getMinimumSize().width, Integer.MAX_VALUE));
        add_factory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_Factory.add(new CREATE_FACTORY_PANEL());
                panel_Factory.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel_Factory.updateUI();
            }
        });
        jPanel.add(add_factory);
        jPanel.add(jScrollPane_Factory);
        setBounds(350, -5, 700, 900);
        jPanel.setBounds(0, 0, 700, 800);
        jLayeredPane.setBounds(0, 0, 700, 700);

//        BoxLayout boxLayout2 = new BoxLayout(panel_Storage, BoxLayout.X_AXIS);
        FlowLayout flowLayout1 = new FlowLayout();
        panel_Storage.setLayout(flowLayout1);
        jPanel.add(panel_Storage.add(new CREATE_STORAGE()));
//        BoxLayout boxLayout1 = new BoxLayout(panel_Transport, BoxLayout.X_AXIS);
        FlowLayout flowLayout2 = new FlowLayout();
        panel_Transport.setLayout(flowLayout2);
        JButton add_transporter = new JButton("ADD TRANSPORT");
        add_transporter.setBackground(new Color(0xF39C63));
        add_transporter.setFont(new Font("Arial", Font.ITALIC, 15));
        add_transporter.setMaximumSize(new Dimension(add_transporter.getMinimumSize().width, Integer.MAX_VALUE));
        add_transporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_Transport.add(new CREATE_TRANSPORTER_PANEL());
                Transporter.increase_Count_of_Trans();
                panel_Transport.updateUI();
            }
        });
        jPanel.add(add_transporter);
        jPanel.add(jScrollPane_Transporter);


        panel.setBounds(0, 0, 700, 800);
        panel.setBackground(null);
        panel.setOpaque(false);
        panel.setLayout(null);
        jLayeredPane.add(jPanel, JLayeredPane.DEFAULT_LAYER);

        jLayeredPane.add(panel, JLayeredPane.POPUP_LAYER);
        add(jLayeredPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        if (balloon_droping_anim.isFlag()){
            balloon_droping_anim=null;
            System.gc();
        }
    }
    public static  void get_anim(){
        panel.add(new Balloon_Droping_anim());
    }

}