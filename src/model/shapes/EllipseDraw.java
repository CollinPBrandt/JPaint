package model.shapes;

import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.awt.*;

public class EllipseDraw implements IDraw {

    @Override
    public void draw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        g.drawOval(shape.getStart().x, shape.getStart().y, Math.abs(shape.getStart().x - shape.getEnd().x), Math.abs(shape.getStart().y - shape.getEnd().y));
    }

    public void paint(Graphics g){
        //Graphics g = canvas.getGraphics2D();
        //g.setColor(ColorAdaptor.ChangeColor(shape));
        //g.drawOval(shape.getStart().x, shape.getStart().y, Math.abs(shape.getStart().x - shape.getEnd().x), Math.abs(shape.getStart().y - shape.getEnd().y));
    }
}
