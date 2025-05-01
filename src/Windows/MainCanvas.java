package Windows;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private long lastFrameTime;
    private final MainWindow controller;

    public MainCanvas(MainWindow controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();

        setBackground(Color.BLUE);


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
        controller.onDrowFrame(this, g, deltaTime);
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
