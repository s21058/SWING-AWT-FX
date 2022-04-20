import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class M extends Frame {
    Image image;
    M() {
        try {
            File imagefile = new File("\\im.png");
            image = ImageIO.read(imagefile);
        } catch (IOException e1) {
            e1.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, getInsets().left, getInsets().top, null);
        try {
            Thread.sleep(1500);
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}