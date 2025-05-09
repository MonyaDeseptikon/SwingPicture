package Sprites.Picture;

import Sprites.Sprite;
import Windows.MainCanvas;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.System.*;

public class Picture2 extends Sprite {


    private float vX;
    private float vY;
    File file;
    private Image pict ;


    public Picture2() throws IOException {
        file = new File(getProperty("user.dir") + "/src/Images/20140624_130424_.jpg");

        try {
            pict = ImageIO.read(file);

        } catch (IOException e) {
            e.printStackTrace();
        }


        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {

        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        halfHeight = (float) pict.getHeight(canvas) / 2;
        halfWidth = (float) pict.getWidth(canvas) / 2;
        g.drawImage(pict, (int) getLeft(), (int) getTop(), canvas);


    }


}
