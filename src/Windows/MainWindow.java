package Windows;

import Sprites.*;


import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.event.MouseEvent.*;

public class MainWindow extends JFrame implements CanvasRepaintListener, MouseListener {
    private static final int POS_X = 10;
    private static final int POS_Y = 10;
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 1000;
    private final Sprite[] sprites = new Sprite[10];
    private final Sprite background;
    MouseEvent e;

    private MainWindow() {
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
                    System.out.println("Нажата левая кнопка");
                    break;
                case 3:
                    System.out.println("Нажата правая кнопка");
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
        new MainWindow();
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
}