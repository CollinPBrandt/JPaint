package model.shapes;

import java.awt.*;

public class ShapeObject {

    private int x;
    private int y;
    private int width;
    private int height;


    public ShapeObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        g.drawOval(x, y, width, height);
    }

}