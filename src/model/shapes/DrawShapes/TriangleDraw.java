package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.shapes.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class TriangleDraw implements IDraw {
    @Override
    public void draw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        int[] sideA = {shape.getDimensions().getStartX(), shape.getDimensions().getStartX() + shape.getDimensions().getWidth(), shape.getDimensions().getStartX()};
        int[] sideB = {shape.getDimensions().getStartY(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight()};
        g.drawPolygon(sideA, sideB, 3);
    }
}
