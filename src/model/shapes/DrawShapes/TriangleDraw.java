package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.shapes.ShapeData.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class TriangleDraw implements IDraw {

    private final ShapeObject shape;
    private final PaintCanvas canvas;
    private final Graphics g;

    public TriangleDraw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        this.shape = shape;
        this.canvas = canvas;
        this.g = g;
    }

    public void draw(Graphics g) {
        int[] sideA = {shape.getDimensions().getStartX(), shape.getDimensions().getStartX() + shape.getDimensions().getWidth(), shape.getDimensions().getStartX()};
        int[] sideB = {shape.getDimensions().getStartY(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight()};
        g.drawPolygon(sideA, sideB, 3);
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }
}
