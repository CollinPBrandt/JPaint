package model.shapes;

import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.awt.*;

public class RectangleDraw implements IDraw {


    @Override
    public void draw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        g.drawRect(shape.getStart().x, shape.getStart().y, Math.abs(shape.getStart().x - shape.getEnd().x), Math.abs(shape.getStart().y - shape.getEnd().y));
    }

    @Override
    public void paint(Graphics g) {

    }
}
