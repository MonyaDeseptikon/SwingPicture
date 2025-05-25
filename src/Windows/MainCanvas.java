package Windows;

import Sprites.CanvasRepaintListener;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final CanvasRepaintListener controller;
    private long lastFrameTime;



    public MainCanvas(CanvasRepaintListener controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();

           }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        try {

            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        /**Без валидации панель может иметь нулевые значения высоты и ширины*/

        validate();
        lastFrameTime = System.nanoTime();
        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }
}
