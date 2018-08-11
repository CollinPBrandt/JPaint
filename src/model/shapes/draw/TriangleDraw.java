package model.shapes.draw;

import model.interfaces.IDraw;
import model.shapes.data.ShapeObject;
import model.shapes.data.ColorAdaptor;
import view.gui.PaintCanvas;

import java.awt.*;

public class TriangleDraw implements IDraw {

    private final ShapeObject shape;
    private final PaintCanvas canvas;

    public TriangleDraw(ShapeObject shape, PaintCanvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void paint() {
        //create new graphic on canvas
        Graphics g = canvas.getGraphics2D();
        //create three sides needed for drawPolygon and fillPolygon functions
        int[] sideA = {shape.getDimensions().getStartX(), shape.getDimensions().getStartX() + shape.getDimensions().getWidth(), shape.getDimensions().getStartX()};
        int[] sideB = {shape.getDimensions().getStartY(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight()};
        //draw polygon shading type depending on shading type
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
        }
    }
}
