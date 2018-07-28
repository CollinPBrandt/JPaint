package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.shapes.ShapeData.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class RectangleDraw implements IDraw {

    private final ShapeObject shape;
    private final PaintCanvas canvas;
    private final Graphics g;

    public RectangleDraw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        this.shape = shape;
        this.canvas = canvas;
        this.g = g;
    }


    public void draw(Graphics g) {
        g.drawRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }
}
