package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.shapes.ShapeData.ShapeObject;
import model.shapes.ShapeEnums.ColorAdaptor;
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

    @Override
    public void paint(Graphics g) {
        int[] sideA = {shape.getDimensions().getStartX(), shape.getDimensions().getStartX() + shape.getDimensions().getWidth(), shape.getDimensions().getStartX()};
        int[] sideB = {shape.getDimensions().getStartY(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight()};
        switch(shape.getShapeShadingType()){
            case FILLED_IN:
                g.setColor(ColorAdaptor.ChangeColor(shape, 'p'));
                g.fillPolygon(sideA, sideB, 3);
                break;
            case OUTLINE:
                g.setColor(ColorAdaptor.ChangeColor(shape, 'p'));
                g.drawPolygon(sideA, sideB, 3);
                break;
            case OUTLINE_AND_FILLED_IN:
                g.setColor(ColorAdaptor.ChangeColor(shape, 'p'));
                g.fillPolygon(sideA, sideB, 3);
                g.setColor(ColorAdaptor.ChangeColor(shape, 's'));
                g.drawPolygon(sideA, sideB, 3);
                break;
            default:
                break;
        }
    }
}
