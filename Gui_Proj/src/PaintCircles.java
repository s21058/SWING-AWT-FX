import org.w3c.dom.Text;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;




class PaintCircles extends Frame {
    ArrayList<GetAndConvertChars> add_list;

    PaintCircles(ArrayList add_list) {
        setBounds(400, 20, 800, 800);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true); // Makes window visible
        this.add_list = add_list;

    }


    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        int w = 0;
        int count = 0;
        ArrayList<ArrayList<Integer>> integer_list = new ArrayList<ArrayList<Integer>>();
        integer_list.add(new ArrayList<Integer>());
        integer_list.add(new ArrayList<Integer>());
        integer_list.add(new ArrayList<Integer>());
        // Wyciągamy z addlist kazdy char i convertujemy go w wartosc binarną i dodajemy na koniec integer_list
        // w++ daltego zeby przeskakiwac przez spacje
        for (int i = 0; i < integer_list.size(); i++) {
            for (; w < this.add_list.size(); w++) {
                if (add_list.get(w).ch == ' ') {
                    w++;
                    count++;
                    break;
                } else {
                    integer_list.get(i).addAll(add_list.get(w).bin);
                }
            }
        }

        for (int i = 0; i < integer_list.size(); i++) {
            Collections.reverse(integer_list.get(i));
        }
//        for (int i = 0; i <integer_list.size() ; i++) {
//            for (int j = 0; j <integer_list.get(i).size() ; j++) {
//                System.out.print(integer_list.get(i).get(j));
//            }
//            System.out.println();
//        }
        double x = 0;
        g.setColor(Color.WHITE);
        Arc2D thirdArc = new Arc2D.Double(100, 100, 600, 600, x, 4.5, Arc2D.PIE);
        g.setColor(Color.WHITE);
        Arc2D secondArc = new Arc2D.Double(200, 200, 400, 400, x, 4.5, Arc2D.PIE);
        g.setColor(Color.WHITE);
        Arc2D firstArc = new Arc2D.Double(300, 300, 200, 200, x, 4.5, Arc2D.PIE);
        boolean getnewrow = false;
        double start = 0;

        //Sprawdzanie ilosci wprowadzonych słów
        switch (count) {
            case 1:
                if (count == 1) {
                    getnewrow = false;
                    for (int i = 0; i < 80; i++) {
                        firstArc.setAngleStart(x);
                        x += 4.5;
                        g.setColor(Color.WHITE);
                        ((Graphics2D) g).fill(firstArc);
                        if (i == integer_list.get(0).size() - 1) {
                            getnewrow = true;
                        }
                        if (!getnewrow) {
                            if (integer_list.get(0).get(i) == 1) {
                                g.setColor(Color.RED);
                                ((Graphics2D) g).fill(firstArc);
                            } else {
                                g.setColor(Color.WHITE);
                                ((Graphics2D) g).fill(firstArc);
                            }
                        }
                    }
                }
            case 2:
                if (count == 2) {
                    getnewrow = false;
                    for (int i = 0; i < 80; i++) {

                        secondArc.setAngleStart(start);
                        start += 4.5;
                        g.setColor(Color.WHITE);
                        ((Graphics2D) g).fill(secondArc);
                        if (i == integer_list.get(1).size() - 1) {
                            x = start;
                            getnewrow = true;
                        }
                        if (!getnewrow) {
                            if (integer_list.get(1).get(i) == 1) {
                                g.setColor(Color.RED);
                                ((Graphics2D) g).fill(secondArc);
                            } else {
                                g.setColor(Color.WHITE);
                                ((Graphics2D) g).fill(secondArc);
                            }
                        }

                    }
                    getnewrow = false;
                    for (int i = 0; i < 80; i++) {
                        firstArc.setAngleStart(x);
                        x += 4.5;
                        g.setColor(Color.WHITE);
                        ((Graphics2D) g).fill(firstArc);
                        if (i == integer_list.get(0).size() - 1) {
                            getnewrow = true;
                        }
                        if (!getnewrow) {
                            if (integer_list.get(0).get(i) == 1) {
                                g.setColor(Color.RED);
                                ((Graphics2D) g).fill(firstArc);
                            } else {
                                g.setColor(Color.WHITE);
                                ((Graphics2D) g).fill(firstArc);
                            }
                        }
                    }
                }
            case 3:
                if (count == 3) {
                    getnewrow = false;
                    for (int i = 0; i < 80; i++) {
                        thirdArc.setAngleStart(x);
                        x += 4.5;
                        g.setColor(Color.WHITE);
                        ((Graphics2D) g).fill(thirdArc);
                        if (i == integer_list.get(2).size() - 1) {
                            start = x;
                            getnewrow = true;
                        }
                        if (!getnewrow) {
                            if (integer_list.get(2).get(i) == 1) {
                                g.setColor(Color.RED);
                                ((Graphics2D) g).fill(thirdArc);
                            } else {
                                g.setColor(Color.WHITE);
                                ((Graphics2D) g).fill(thirdArc);
                            }
                        }

                    }
                    getnewrow = false;
                    for (int i = 0; i < 80; i++) {

                        secondArc.setAngleStart(start);
                        start += 4.5;
                        g.setColor(Color.WHITE);
                        ((Graphics2D) g).fill(secondArc);
                        if (i == integer_list.get(1).size() - 1) {
                            x = start;
                            getnewrow = true;
                        }
                        if (!getnewrow) {
                            if (integer_list.get(1).get(i) == 1) {
                                g.setColor(Color.RED);
                                ((Graphics2D) g).fill(secondArc);
                            } else {
                                g.setColor(Color.WHITE);
                                ((Graphics2D) g).fill(secondArc);
                            }
                        }

                    }
                    getnewrow = false;
                    for (int i = 0; i < 80; i++) {
                        firstArc.setAngleStart(x);
                        x += 4.5;
                        g.setColor(Color.WHITE);
                        ((Graphics2D) g).fill(firstArc);
                        if (i == integer_list.get(0).size() - 1) {
                            getnewrow = true;
                        }
                        if (!getnewrow) {
                            if (integer_list.get(0).get(i) == 1) {
                                g.setColor(Color.RED);
                                ((Graphics2D) g).fill(firstArc);
                            } else {
                                g.setColor(Color.WHITE);
                                ((Graphics2D) g).fill(firstArc);
                            }
                        }
                    }
                }
        }

        g2.setStroke(new BasicStroke(1));
        g.setColor(Color.BLACK);
        g.fillOval(375, 375, 50, 50);
        g.drawOval(300, 300, 200, 200);
        g.drawOval(200, 200, 400, 400);
        g.drawOval(100, 100, 600, 600);

        int const_raduis = 400; // dlugosc okna/2
        // ilosc punktów na okręgu(black) po X oraz Y
        int[] zero_circle_X_points = new int[80];
        int[] zero_circle_Y_points = new int[80];
        double i;
        int j;
        // otrzymujemy punkty po X i Y circle(black) okregu
        for (i = 0, j = 0; i <= 360 && j < zero_circle_X_points.length; i = (i + 4.5), j++) {
            zero_circle_X_points[j] = (int) (const_raduis + (25 * Math.cos(Math.toRadians(i))));   //X= X0+R*sin(angle)
            zero_circle_Y_points[j] = (int) (const_raduis + (25 * Math.sin(Math.toRadians(i))));   // Y= Y0+R*sin(angle)
        }

        // ilosc punktów na okręgu(1) po X oraz Y
        int[] first_circle_X_points = new int[80];
        int[] first_circle_Y_points = new int[80];
        // otrzymujemy punkty po X i Y circle(1) okregu
        for (i = 0, j = 0; i <= 360 && j < zero_circle_X_points.length; i = (i + 4.5), j++) {
            first_circle_X_points[j] = (int) (const_raduis + (100 * Math.cos(Math.toRadians(i))));  //X= X0+R*sin(angle)
            first_circle_Y_points[j] = (int) (const_raduis + (100 * Math.sin(Math.toRadians(i))));  // Y= Y0+R*sin(angle)
        }
        // Rysujemy linie od kazdego punktu zero circle X i Y do kazdego punktu X i Y first circle
        for (int k = 0; k < first_circle_X_points.length; k++) {
            g.drawLine(zero_circle_X_points[k], zero_circle_Y_points[k], first_circle_X_points[k], first_circle_Y_points[k]);
        }
        // ilosc punktów na okręgu(2) po X oraz Y
        int[] second_circle_X_points = new int[80];
        int[] second_circle_Y_points = new int[80];
        // otrzymujemy punkty po X i Y circle(2) okregu
        for (i = 0, j = 0; i <= 360 && j < zero_circle_X_points.length; i = (i + 4.5), j++) {
            second_circle_X_points[j] = (int) (const_raduis + (200 * Math.cos(Math.toRadians(i))));  // X= X0+R*cos(angle)
            second_circle_Y_points[j] = (int) (const_raduis + (200 * Math.sin(Math.toRadians(i))));  // Y= Y0+R*sin(angle)
        }
        g.setColor(Color.BLACK);
        // Rysujemy linie od kazdego punktu fisrt circle X i Y do kazdego punktu X i Y second circle
        for (int k = 0; k < first_circle_X_points.length; k++) {
            g.drawLine(first_circle_X_points[k], first_circle_Y_points[k], second_circle_X_points[k], second_circle_Y_points[k]);
        }
        // ilosc punktów na okręgu(3) po X oraz Y
        int[] third_circle_X_points = new int[80];
        int[] third_circle_Y_points = new int[80];
        // otrzymujemy punkty po X i Y circle(3) okregu
        for (i = 0, j = 0; i <= 360 && j < zero_circle_X_points.length; i = (i + 4.5), j++) {
            third_circle_X_points[j] = (int) (const_raduis + (300 * Math.cos(Math.toRadians(i))));
            third_circle_Y_points[j] = (int) (const_raduis + (300 * Math.sin(Math.toRadians(i))));
        }
        g.setColor(Color.BLACK);
        // Rysujemy linie od kazdego punktu second circle X i Y do kazdego punktu X i Y third circle
        for (int k = 0; k < first_circle_X_points.length; k++) {
            g.drawLine(second_circle_X_points[k], second_circle_Y_points[k], third_circle_X_points[k], third_circle_Y_points[k]);
        }

        g.drawLine(0, 0, 800, 800);
        g.drawLine(800, 0, 0, 800);
        g.drawLine(400, 0, 400, 800);
        g.drawLine(0, 400, 800, 400);

        Button button = new Button("DECODE");
        button.setBounds(700, 30, 80, 20);
        add(button);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                Frame frame = new Frame("DECODED WORDS");
                frame.setBounds(200, 200, 800, 300);
                Button button1 = new Button("Click");
                button1.setBounds(700, 30, 80, 20);
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        M m = new M();
                        m.setSize(new Dimension(1920,1080));
                        m.setVisible(true);

                    }
                });

                Panel panel = new Panel();
                panel.setLayout(null);
                Label label = new Label();
                label.setBounds(50, 50, 600, 30);


                Label binary_word = new Label();
                binary_word.setBounds(20, 100, 800, 30);

                Label binary_word1 = new Label();
                binary_word1.setBounds(20, 150, 800, 30);

                Label binary_word2 = new Label();
                binary_word2.setBounds(20, 200, 800, 30);

                String word = "";
                StringBuilder binary = new StringBuilder();
                StringBuilder binary1 = new StringBuilder();
                StringBuilder binary2 = new StringBuilder();

                for (int k = 0; k < add_list.size(); k++) {
                    word += add_list.get(k).ch + " ";
                }
                for (int k = 0; k < integer_list.get(0).size(); k++) {
                    binary.append(integer_list.get(0).get(k)).append(" ");
                }
                for (int k = 0; k < integer_list.get(1).size(); k++) {
                    binary1.append(integer_list.get(1).get(k)).append(" ");
                }
                for (int k = 0; k < integer_list.get(2).size(); k++) {
                    binary2.append(integer_list.get(2).get(k)).append(" ");
                }


//                for (int k = 0; k <add_list.size() ; k++) {
//                    binary.append(add_list.get(k).bin).append(" ");
//                    if(add_list.get(k).ch==' '){
//                        break;
//                    }
//                }


                label.setFont(new Font("Serif", Font.PLAIN, 28));
                binary_word.setFont(new Font("Serif", Font.PLAIN, 15));
                binary_word1.setFont(new Font("Serif", Font.PLAIN, 15));
                binary_word2.setFont(new Font("Serif", Font.PLAIN, 15));


                label.setText(word);


                binary_word.setText(binary.toString());
                binary_word1.setText(binary1.toString());
                binary_word2.setText(binary2.toString());

                panel.add(label);

                panel.add(binary_word);
                panel.add(binary_word1);
                panel.add(binary_word2);
                panel.add(button1);
                frame.add(panel);
                frame.setVisible(true);
            }

        });

    }
}




//    @Override
//    public void paint(Graphics g) {
//        Graphics2D g2 =(Graphics2D)g;
//        double i;
//        int j;
//        final int const_radius = 400;
//
//        // -------------------------SETTINGS FOR BLACK CIRCLE IN THE CENTER------------------------------
//        g.setColor(Color.BLACK);
//        int d_of_start_sircle=50;
//        int pos_of_start_circles=375;
//        g.fillOval(pos_of_start_circles,pos_of_start_circles,d_of_start_sircle,d_of_start_sircle);
//        int [] poz_of_X_start_circle=new int[80];
//        int [] poz_of_Y_start_circle=new int[80];
//        for (i = 0, j = 0; i <= 360 && j < poz_of_X_start_circle.length; i = (i + 4.5), j++) {
//            poz_of_X_start_circle[j] = (int) (const_radius + (d_of_start_sircle/2 * Math.cos(Math.toRadians(i))));
//            poz_of_Y_start_circle[j] = (int) (const_radius + (d_of_start_sircle/2 * Math.sin(Math.toRadians(i))));
//        }
//        // -------------------------SETTINGS FOR FIRST CIRCLE------------------------------------
//        int poz_of_cirles=pos_of_start_circles-d_of_start_sircle/2;
//        int d_of_cirlce=d_of_start_sircle*2;
//        g.setColor(Color.black);
//        g.drawOval(poz_of_cirles, poz_of_cirles, d_of_cirlce, d_of_cirlce);
//
//        int r_of_circle = d_of_cirlce / 2;
//
//        int[] poz_of_X_zero_circle = new int[80];
//        int[] poz_of_Y_zero_circle = new int[80];
//        for (i = 0, j = 0; i <= 360 && j < poz_of_X_zero_circle.length; i = (i + 4.5), j++) {
//            poz_of_X_zero_circle[j] = (int) (const_radius + (r_of_circle * Math.cos(Math.toRadians(i))));
//            poz_of_Y_zero_circle[j] = (int) (const_radius + (r_of_circle * Math.sin(Math.toRadians(i))));
//        }
//        for (int k = 0; k < poz_of_X_zero_circle.length; k++) {
//            System.out.println("x " + poz_of_X_zero_circle[k] + " " + "y " + poz_of_Y_zero_circle[k]);
//        }
//
//        System.out.println("------------------------------------------------------------------------------------");
//        System.out.println("------------------------------------------------------------------------------------");
//        System.out.println("------------------------------------------------------------------------------------");
//
//
//        // --------------------SETTINGS FOR SECOND CIRCLE---------------------------
//        int d_of_first_circle = d_of_cirlce + r_of_circle * 2;
//        g.drawOval(poz_of_cirles - d_of_cirlce / 2, poz_of_cirles - d_of_cirlce / 2, d_of_first_circle, d_of_first_circle);
//        int[] poz_of_X_first_circle = new int[80];
//
//        int[] poz_of_Y_first_circle = new int[80];
//        for (i = 0, j = 0; i <= 360 && j < poz_of_X_zero_circle.length; i = (i + 4.5), j++) {
//            poz_of_X_first_circle[j] = (int) (const_radius + ((d_of_first_circle / 2) * Math.cos(Math.toRadians(i))));
//            poz_of_Y_first_circle[j] = (int) (const_radius + ((d_of_first_circle / 2) * Math.sin(Math.toRadians(i))));
//        }
//        for (int k = 0; k < poz_of_X_zero_circle.length; k++) {
//            System.out.println("x1 " + poz_of_X_first_circle[k] + " " + "y1 " + poz_of_Y_first_circle[k]);
//        }
//
//
//        g.drawLine(0, 0, 800, 800);
//        g.drawLine(800, 0, 0, 800);
//        g.drawLine(const_radius, 0, const_radius, 800);
//        g.drawLine(0, const_radius, 800, const_radius);
//        String arr[]=new String[80];
//        for (int k = 0; k <arr.length ; k++) {
//            if(k%2==0){
//                arr[k]="0";
//            }else{
//                arr[k]="1";
//            }
//        }
//        //  DRAWING LINES BETWEEN BLACK CIRCLE AND FIRST
//        int x=4;
//        for (int k = 0; k <poz_of_X_start_circle.length ; k++) {
//            g.drawArc(poz_of_X_start_circle[k],poz_of_Y_start_circle[k],4,d_of_start_sircle,0,x=x+4);
//
//          //  g.drawArc(poz_of_X_start_circle[k],poz_of_Y_start_circle[k],poz_of_X_zero_circle[k],poz_of_Y_zero_circle[k],0, (int) (x+=4.5));
//
////            g.drawLine(poz_of_X_start_circle[k],poz_of_Y_start_circle[k],poz_of_X_zero_circle[k],poz_of_Y_zero_circle[k]);
//
//        }
//        // DRAWING LINES BETWEEN FIRST CIRCLE AND SECOND
////       ` for (int k = 0; k < poz_of_X_first_circle.length; k++) {
////            g.drawLine(poz_of_X_zero_circle[k], poz_of_Y_zero_circle[k], poz_of_X_first_circle[k], poz_of_Y_first_circle[k]);
////        }`
//
//    }
//}*/
