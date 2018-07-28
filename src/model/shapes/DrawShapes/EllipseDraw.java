package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.shapes.ShapeData.ShapeObject;
import view.gui.PaintCanvas;

import javax.swing.*;
import java.awt.*;

public class EllipseDraw extends JPanel implements IDraw {

    private final ShapeObject shape;
    private final PaintCanvas canvas;
    private final Graphics g;

    public EllipseDraw(ShapeObject shape, PaintCanvas canvas, Graphics g) {
        this.shape = shape;
        this.canvas = canvas;
        this.g = g;
    }

    public void draw(Graphics g) {
        g.drawOval(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }
}
