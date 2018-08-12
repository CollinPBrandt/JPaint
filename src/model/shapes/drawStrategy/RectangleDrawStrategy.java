package model.shapes.drawStrategy;

import model.interfaces.IDrawStrategy;
import model.shapes.shapedata.ShapeObject;
import model.shapes.shapedata.ColorAdaptor;
import view.gui.PaintCanvas;

import java.awt.*;

public class RectangleDrawStrategy implements IDrawStrategy {

    private final ShapeObject shape;
    private final PaintCanvas canvas;

    public RectangleDrawStrategy(ShapeObject shape, PaintCanvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void draw() {
        //create new graphic on canvas
        Graphics g = canvas.getGraphics2D();
        //drawStrategy ellipse depending on shape shading type
        switch(shape.getShapeShadingType()){
            case FILLED_IN:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.fillRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                break;
            case OUTLINE:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.drawRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                break;
            case OUTLINE_AND_FILLED_IN:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.fillRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                g.setColor(ColorAdaptor.adaptColor(shape.getShapeSecondaryColor()));
                g.drawRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                break;
        }
    }
}
