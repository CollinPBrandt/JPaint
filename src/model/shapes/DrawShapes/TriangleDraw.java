package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.shapes.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class TriangleDraw implements IDraw {
    @Override
    public void draw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        int[] sideA = {shape.getStart().x, shape.getEnd().x, shape.getStart().x};
        int[] sideB = {shape.getStart().y, shape.getEnd().y, shape.getEnd().y};
        g.drawPolygon(sideA, sideB, 3);
    }
}
