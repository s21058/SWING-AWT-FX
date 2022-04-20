import javax.swing.*;
import java.awt.*;

public class Balloon extends JPanel {
    static long number=0;
    long id_balloon;

    BallonColor color;
    Balloon(BallonColor color) {
       id_balloon=number++;
        System.out.println(color);
    }
}
