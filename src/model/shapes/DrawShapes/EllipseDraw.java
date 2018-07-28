package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.shapes.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class EllipseDraw implements IDraw {

    @Override
    public void draw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        g.drawOval(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
    }
}
