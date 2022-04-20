import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Balloon_Droping_anim extends JPanel implements ActionListener {
Timer timer= new Timer(5,this);
boolean flag=true;
int x=0, y=900;
Image balloon;
Balloon_Droping_anim(){
    loadImages();
    setSize(new Dimension(700,900));
    setBackground(null);
    setOpaque(false);
    setVisible(true);
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(balloon,x,y,700,400,this);
        timer.start();
        flag=true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int velY=2;
        y-=velY;
        if (y==-400){
            timer.stop();
            flag=false;
            balloon=null;
            System.gc();
        }
        repaint();
    }

    public  boolean isFlag() {
        return flag;
    }

    public void loadImages() {
        ImageIcon iia = new ImageIcon("balloon.png");
        balloon = iia.getImage();
//        Image newimg1 = balloon.getScaledInstance(1700, 1500, java.awt.Image.SCALE_SMOOTH);
//        ImageIcon newIcon1 = new ImageIcon(newimg1);
//        balloon = newIcon1.getImage();

    }
}
