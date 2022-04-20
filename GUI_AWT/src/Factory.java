import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Factory extends Frame {
    Factory() {
        Frame frame = new Frame();
        frame.setBounds(400,20,800,800);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        Panel panel= new Panel();
        panel.setLayout(null);
        Button button = new Button("click");
        button.setBounds(300,300,100,100);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
//        JFrame frame = new JFrame("Window");
//        frame.setBounds(500, 250, 500, 500);
//        JPanel jPanel = new JPanel();
//        jPanel.setLayout(null);
//        JButton button = new JButton("Click");
//        jPanel.add(button);
//        frame.add(jPanel);
//        frame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                for (int i = 0; i < 1; i++) {
//                    super.mouseClicked(e);
//                    button.setBounds(e.getX() - button.getWidth() / 2, e.getY() - button.getHeight(), 150, 50);
//                    System.out.println(e.getX() + " " + e.getY() + "\n");
//
//                }
//                if (button.getX() <= 0 && button.getY() <= 250 || button.getX() <= 250 && button.getY() <= 250) {
//                    button.setBackground(Color.cyan);
//                } else if (button.getX() > 251 && button.getY() <= 250 || button.getX() <= 500 && button.getY() <= 250) {
//                    button.setBackground(Color.GREEN);
//                } else if (button.getX() > 251 && button.getY() >= 250 || button.getX() <= 500 && button.getY() <= 500) {
//                    button.setBackground(Color.orange);
//                }
//            }
//        });
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("poisition x button: " + button.getX() + " " + "position y button: " + button.getY() + "\n");
//            }
//        });
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}