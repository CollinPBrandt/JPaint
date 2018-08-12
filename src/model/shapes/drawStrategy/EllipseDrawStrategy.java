package model.shapes.drawStrategy;

import model.interfaces.IDrawStrategy;
import model.shapes.shapedata.ShapeObject;
import model.shapes.shapedata.ColorAdaptor;
import view.gui.PaintCanvas;

import java.awt.*;

public class EllipseDrawStrategy implements IDrawStrategy {

    private final ShapeObject shape;
    private final PaintCanvas canvas;

    public EllipseDrawStrategy(ShapeObject shape, PaintCanvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void draw() {
        //create new graphic on canvas
        Graphics g = canvas.getGraphics2D();
        //Draw ellipse depending on shape shading type
        switch(shape.getShapeShadingType()){
            case FILLED_IN:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.fillOval(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                break;
            case OUTLINE:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.drawOval(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                break;
            case OUTLINE_AND_FILLED_IN:
                g.setColor(ColorAdaptor.adaptColor(shape.getShapePrimaryColor()));
                g.fillOval(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                g.setColor(ColorAdaptor.adaptColor(shape.getShapeSecondaryColor()));
                g.drawOval(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth() - 1 , shape.getDimensions().getHeight() - 1); //looks better with 1px smaller outline
                break;
        }
    }
}
