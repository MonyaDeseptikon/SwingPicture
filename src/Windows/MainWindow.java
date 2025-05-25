package Windows;

import Sprites.*;
import Sprites.Picture.Picture1;
import Sprites.Picture.Picture2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class MainWindow extends JFrame implements CanvasRepaintListener, MouseListener {



    private static final int POS_X = 10;
    private static final int POS_Y = 10;
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 1000;
    private final Sprite[] sprites;
    private final Sprite background;
    MouseEvent e;


    public MainWindow() throws IOException {

        sprites = new Sprite[10];

        background = new Background();
        for (int i = 0; i < sprites.length / 2; i++) {
            sprites[i] = new Picture1();
        }
        for (int i = sprites.length / 2; i < sprites.length; i++) {
            sprites[i] = new Picture2();
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);

        setVisible(true);

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        canvas.addMouseListener(this);
        setVisible(true);



    }

    public static void main(String[] args) throws IOException {
        new MainWindow();
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);

    }

    private void update(MainCanvas canvas, float deltaTime) {
        background.update(canvas, deltaTime);
        for (Sprite sprite : sprites) sprite.update(canvas, deltaTime);
    }

private void render(MainCanvas canvas, Graphics g) {
    background.render(canvas, g);
    for (Sprite sprite : sprites) sprite.render(canvas, g);
    if (e != null && e.getButton() == 1 && e.getClickCount()==2) this.dispose();
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