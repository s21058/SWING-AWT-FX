import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Main extends Frame {
    public static void main(String[] args) {
        if (args.length > 3||args.length==0) {
            System.err.println("The count of parameters is more than 3 or equal 0");
            Frame frame = new Frame("ERROR MESSAGE");
            frame.setBounds(500,350,500,150);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    frame.dispose();
                }
            });

            Panel panel = new Panel();
            panel.setLayout(null);
            Label label = new Label();
            label.setForeground(Color.RED);
            label.setFont(new Font("Serif", Font.PLAIN, 20));
            label.setText("The count of parameters is more than 3 or equal 0");
            label.setBounds(0,20,500,20);
            panel.add(label);
            frame.add(panel);
            frame.setVisible(true);


        } else {
            StringBuilder param = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                param.append(args[i]).append(" ");
            }


            char[] mass = param.toString().toCharArray();

            ArrayList<GetAndConvertChars> add_list = new ArrayList<>();
            for (int i = 0; i < mass.length; i++) {
                add_list.add(new GetAndConvertChars(mass[i]));
            }

            PaintCircles paintCircles = new PaintCircles(add_list);

        }
    }
}
