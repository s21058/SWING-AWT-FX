import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.FileReader;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class Balloon extends JFrame {

    TextField input = new TextField();
    public Balloon() {
        Frame frame = new Frame("Create n-count of balloons");
        frame.setBounds(600, 250, 200, 200);

        Button close = new Button("Close");
        close.setBounds(10, 130, 70, 20);

        Button setNumber = new Button("Set");
        setNumber.setBounds(100,100,70,20);


        input.setBounds(10,100,70,20);
        frame.add(setNumber);
        frame.add(input);
        frame.add(close);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        frame.setLayout(null);
        frame.setVisible(true);
            setNumber.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Integer.parseInt(input.getText()) > 99 || Integer.parseInt(input.getText()) < 0) {
                        System.err.println("Too big or too small number");
                        new Balloon();
                    } else {
                        System.out.println(input.getText());
                    }
                }
            });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
}