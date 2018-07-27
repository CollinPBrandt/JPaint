package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.shapes.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class EllipseDraw implements IDraw {

    @Override
    public void draw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        g.drawOval(shape.getStart().x, shape.getStart().y, Math.abs(shape.getStart().x - shape.getEnd().x), Math.abs(shape.getStart().y - shape.getEnd().y));
        //g.setColor(ColorAdaptor.ChangeColor(shape, 's'));
        //g.fillOval(shape.getStart().x, shape.getStart().y, Math.abs(shape.getStart().x - shape.getEnd().x), Math.abs(shape.getStart().y - shape.getEnd().y));
    }
}
