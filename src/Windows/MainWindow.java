package Windows;

import Sprites.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame implements CanvasRepaintListener, MouseListener, Thread.UncaughtExceptionHandler {
private static int i=10;
    private static int j=2;

    private static final int POS_X = 10;
    private static final int POS_Y = 10;
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 1000;
    private Sprite[] sprites;
    private final Sprite background;
    MouseEvent e;
    int amountSpr;

    public MainWindow(int amountSpr) {
        // Вариант ловли исключения
//        try {if(amountSpr>5){}} catch (Exception e){
//          throw  new RuntimeException(e);
//        }
//        finally {
//            amountSpr=5;
//        }
        sprites = new Sprite[amountSpr];
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Шарики Кружочки");
        setVisible(true);

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        canvas.addMouseListener(this);
        setVisible(true);

        background = new Background();
        for (int i = 0; i < sprites.length; i++) {
            if (i > 5) throw new RuntimeException("Не может быть более 5 фигур"); //Генерирование ошибки
            sprites[i] = new Ball();

        }

    }


    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);

        render(canvas, g);

    }

    private void update(MainCanvas canvas, float deltaTime) {
        background.update(canvas, deltaTime);

        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        background.render(canvas, g);

        if (e != null) {
            switch (e.getButton()) {
                case 1:
//                System.out.println("Нажата левая кнопка");
                    break;
                case 3:
//                System.out.println("Нажата правая кнопка");
                    for (int i = 0; i < sprites.length; i++) {
                        sprites[i].render(canvas, g);
                    }
                    break;
            }
        } else {
            for (int i = 0; i < sprites.length; i++) {
                sprites[i].render(canvas, g);
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow(i);
                new MainWindow(j);
            }
        });
    }



    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.e = e;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("Кнопка мыши ОТПУЩЕНА");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("Курсор мыши появился в окне");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("Курсор мыши ПОКИНУЛ окно");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
int i = MainWindow.i;
        int j =MainWindow.j;
        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        this.dispose();
        this.dispose();
        if (i>5) i=5;
        if (j>5) j=5;
        new MainWindow(i);
        new MainWindow(j);


    }
}