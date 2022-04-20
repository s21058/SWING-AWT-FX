import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.Formatter;
import java.util.Random;
import javax.swing.*;
/**
 * One ball bouncing inside a rectangular box.
 * All codes in one file. Poor design!
 */
// Extends JPanel, so as to override the paintComponent() for custom rendering codes.
public class Ball extends JPanel  {
    // Container box's width and height
    private static final int BOX_WIDTH = 640;
    private static final int BOX_HEIGHT = 480;
    // Ball's properties
    private static final float ballRadius = 10; // Ball's radius
    //    private float ballX = ballRadius + 50; // Ball's center (x, y)
    private float ballX = 250; // Ball's center (x, y)
    //    private float ballY = ballRadius + 20;

    private float ballY = 0;
    private float ballSpeedX = 15;   // Ball's speed for x and y
    private float ballSpeedY = (float) 7.5;
    private Image palka;
    private float palkaW = 10;
    private float palkaH = 100;
    private float palkaW1 = 10;
    private float palkaH1 = 100;
    private static float palkaX = BOX_WIDTH - 50;
    private static float palkaX1 =  50;
    float mm=60;
    private float palkaY = 80;
    private float palkaY1 = 80;
    private int count_right_palyer=0;
    private int count_left_player=0;
    private static final int UPDATE_RATE = 30; // Number of refresh per second
    boolean ingame=true;
    boolean allgame=true;
    private static float do_smth_Y=40f;


    /**
     * Constructor to create the UI components and init game objects.
     */


    public Ball() {
        loadImages();
        setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e1) {
                super.keyPressed(e1);
                if(e1.getKeyCode()==KeyEvent.VK_UP){
                    palkaY=palkaY-do_smth_Y;

                }
                if(e1.getKeyCode()==KeyEvent.VK_DOWN){
                    palkaY= palkaY+do_smth_Y;
                }
                if(palkaY+100>BOX_HEIGHT) {
                    palkaY = BOX_HEIGHT-101;
                }else if (palkaY < 0) {
                    palkaY = +1;
                }

            }
        });
//        addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                super.mouseClicked(e);
//                palkaY=e.getY();
//
//                if(palkaY+100>BOX_HEIGHT) {
//                    palkaY = BOX_HEIGHT-101;
//                }else if (palkaY < 0) {
//                    palkaY = +1;
//                }
//
//            }
//        });
//        addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e1) {
//                super.mouseClicked(e1);
//                palkaY1=e1.getY();
//
//                if(palkaY1+100>BOX_HEIGHT) {
//                    palkaY1 = BOX_HEIGHT-101;
//                }else if (palkaY1 < 0) {
//                    palkaY1 = +1;
//                }
//
//            }
//        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_W){
                    palkaY1= palkaY1-do_smth_Y;

                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    palkaY1=palkaY1+do_smth_Y;
                }
                if(palkaY1+100>BOX_HEIGHT) {
                    palkaY1 = BOX_HEIGHT-101;
                }else if (palkaY1 < 0) {
                    palkaY1 = +1;
                }

            }
        });

        //ballY = random.nextInt((int) (BOX_HEIGHT - ballRadius * 2 - 20)) + ballRadius + 10;
        //ballX = random.nextInt((int) (BOX_WIDTH - ballRadius * 2 - 20)) + ballRadius + 10;
        // Start the ball bouncing (in its own thread)
        Thread gameThread = new Thread() {
            public void run() {

                while (ingame) { // Execute one update step

                    // Calculate the ball's new position
                    ballX += ballSpeedX;
                    ballY += ballSpeedY;
                    // Check if the ball moves over the bounds
                    // If so, adjust the position and speed.
                    if (ballX - ballRadius < 0) {
                        count_right_palyer++;
//                        ballSpeedX = -ballSpeedX; // Reflect along normal
//                        ballX = ballRadius; // Re-position the ball at the edge
                        ingame=false;
//                        System.exit(0);
                    } else if (ballX + ballRadius > BOX_WIDTH) {
                        count_left_player++;
//                        ballSpeedX = -ballSpeedX;
//                        ballX = BOX_WIDTH - ballRadius;
                      //  System.exit(0);
                        ingame=false;
                    }

                    if (ballX + ballRadius > palkaX) {
                        if (ballY > palkaY && ballY < palkaY+100) {
                            ballSpeedX = -ballSpeedX;
                            ballX = palkaX - ballRadius;
                        }
                    }

                    if(ballX-ballRadius<palkaX1+palkaW1){
                        if(ballY>palkaY1&&ballY<palkaY1+100){
                            ballSpeedX = -ballSpeedX; // Reflect along normal
                            ballX = palkaX1+palkaW1;
                        }

                    }
                    // May cross both x and y bounds
                    if (ballY - ballRadius < 0) {
                        ballSpeedY = -ballSpeedY;
                        ballY = ballRadius;
                    } else if (ballY + ballRadius > BOX_HEIGHT) {
                        ballSpeedY = -ballSpeedY;
                        ballY = BOX_HEIGHT - ballRadius;
                    }

                    // Refresh the display
                    repaint(); // Callback paintComponent()
                    // Delay for timing control and give other threads a chance
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
                    } catch (InterruptedException ex) {
                    }

                }
            }

        };
        gameThread.start();// Callback run()


    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.BLACK);
        Font f1=new Font("Arial",Font.BOLD,150);
        int scoreR=count_right_palyer;
        int scoreL=count_left_player;
        String right_player_score=""+scoreR;
        String whoWinR="RIGHT WIN";
        String whoWinL="LEFT WIN";
        g.setColor(Color.WHITE);
        if(scoreR==8){
            Font f2=new Font("Arial",Font.BOLD,75);
            g.setFont(f2);
            g.drawString(whoWinR,100,300);
            allgame=false;
        }else if(scoreL==8){
            Font f2=new Font("Arial",Font.BOLD,75);
            g.setFont(f2);
            g.drawString(whoWinL,100,300);
            allgame=false;
        }
        String left_player_score=""+scoreL;
        g.setColor(Color.WHITE);
        g.setFont(f1);
        g.drawString(right_player_score,450,150);
        g.drawString(left_player_score,BOX_WIDTH/2-190,150);
    }

    /**
     * Custom rendering codes for drawing the JPanel
     */

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // Paint background
    // Draw the box
    if (ingame) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
        // Draw the ball


        g.setColor(Color.WHITE);
        g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
                (int) (2 * ballRadius), (int) (2 * ballRadius));
        //g.fillRect((int) palkaX, (int) palkaY, (int) palkaW, (int) palkaH);
//            g.drawLine(0, (int) palkaY + 100, BOX_WIDTH - 50, (int) palkaY + 100);
        g.drawLine(BOX_WIDTH / 2, 0, BOX_WIDTH / 2, BOX_HEIGHT);
        g.drawImage(palka, (int) palkaX, (int) palkaY, (int) palkaW, (int) palkaH, this);
        g.drawImage(palka, (int) palkaX1, (int) palkaY1, (int) palkaW1, (int) palkaH1, this);

    } else {
        new Ball();
        palkaX = BOX_WIDTH - 50;
        palkaX1 = 50;
        palkaY = 80;
        palkaY1 = 80;
        ballX = 250;
        ballY = 0;
        palkaW1 = 10;
        palkaH1 = 100;
        palkaW = 10;
        allgame=true;
        palkaH = 100;
//        do_smth_Y= (float) 0.5;
        ingame = true;
        repaint();

    }
    if(allgame==false){
        try {
            Thread.sleep(1500);
            ingame=false;
            count_right_palyer=0;
            count_left_player=0;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         }
}


    public void loadImages() {
        ImageIcon iia = new ImageIcon("line.jpg");
        palka = iia.getImage();
        Image newimg1 = palka.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon1 = new ImageIcon(newimg1);
        palka = newIcon1.getImage();

    }


}



