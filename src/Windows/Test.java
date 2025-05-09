package Windows;

import javax.swing.*;
import java.awt.*;



public class Test extends JFrame {
    private static final int POS_X = 50;
    private static final int POS_Y = 50;
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 1000;



    Test() {
//        if (pict != null) System.out.println(pict);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Тест");
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setVisible(true);
        this.add(panel);
        validate();



        ImageIcon pict = new ImageIcon(System.getProperty("user.dir") + "/src/Images/1_1.png");
       //Изменение размера изображения
//        pict = new ImageIcon(pict.getImage().getScaledInstance(600,400, SCALE_SMOOTH));
       //
        JLabel label = new JLabel(pict);
        panel.add(label);
        validate();




    }

    public static void main(String[] args) {
        new Test();

    }

//    private ImageIcon transformPict(ImageIcon pict, int panelWidth, int panelHeight) {
////        Image image = pict.getImage();
//
////        return new ImageIcon(pict.getImage().getScaledInstance(panelWidth / 4, panelHeight / 4, SCALE_REPLICATE));
//////        return new ImageIcon(image.getScaledInstance(500, 500, SCALE_DEFAULT));
//
//    }

}
