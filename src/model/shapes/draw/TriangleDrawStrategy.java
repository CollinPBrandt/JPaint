package model.shapes.draw;

import model.interfaces.IDrawStrategy;
import model.shapes.data.ShapeObject;
import model.shapes.data.ColorAdaptor;
import view.gui.PaintCanvas;

import java.awt.*;

public class TriangleDrawStrategy implements IDrawStrategy {

    private final ShapeObject shape;
    private final PaintCanvas canvas;

    public TriangleDrawStrategy(ShapeObject shape, PaintCanvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void draw() {
        //create new graphic on canvas
        Graphics g = canvas.getGraphics2D();
        //create three sides needed for drawPolygon and fillPolygon functions
        int[] sideA = {shape.getDimensions().getStartX(), shape.getDimensions().getStartX() + shape.getDimensions().getWidth(), shape.getDimensions().getStartX()};
        int[] sideB = {shape.getDimensions().getStartY(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight(), shape.getDimensions().getStartY() + shape.getDimensions().getHeight()};
        //draw polygon shading type depending on shading type
        switch(shape.getShapeShadingType()){
            case FILLED_IN:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.fillPolygon(sideA, sideB, 3);
                break;
            case OUTLINE:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.drawPolygon(sideA, sideB, 3);
                break;
            case OUTLINE_AND_FILLED_IN:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.fillPolygon(sideA, sideB, 3);
                g.setColor(ColorAdaptor.adaptColor(shape.getShapeSecondaryColor()));
                g.drawPolygon(sideA, sideB, 3);
                break;
        }
    }
}
