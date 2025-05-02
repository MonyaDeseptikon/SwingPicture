package Windows;

import Sprites.*;
import Sprites.Rectangle;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 250;
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 1000;
    private final Sprite[] sprites = new Sprite[10];
    private final Rectangle[] rectangles = new Rectangle[5];

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Шарики Кружочки");
        setVisible(true);

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle();
        }
        sprites[0]=new Background();
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

    }
    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].update(canvas, deltaTime);
        }
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }

    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].render(canvas, g);
        }
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }

    }


    public static void main(String[] args) {
        new MainWindow();
    }
}