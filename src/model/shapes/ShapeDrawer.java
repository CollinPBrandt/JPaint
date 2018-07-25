package model.shapes;

import view.gui.PaintCanvas;

import java.awt.*;

public class ShapeDrawer {

    PaintCanvas canvas;
    ShapeList shapeList;
    Graphics g;

    public ShapeDrawer(PaintCanvas canvas, ShapeList shapeList) {
        this.canvas = canvas;
        Graphics g = canvas.getGraphics2D();
    }

    public void paint(Graphics g) {
        for(ShapeObject shape : shapeList.shapeList) {
            shape.draw(g);
        }
    }
}
