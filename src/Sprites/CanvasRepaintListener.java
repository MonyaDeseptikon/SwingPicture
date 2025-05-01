package Sprites;

import Windows.MainCanvas;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float detaTime);
}

