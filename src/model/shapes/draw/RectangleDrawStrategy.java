package model.shapes.draw;

import model.interfaces.IDrawStrategy;
import model.shapes.data.ShapeObject;
import model.shapes.data.ColorAdaptor;
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
        //draw ellipse depending on shape shading type
        switch(shape.getShapeShadingType()){
            case FILLED_IN:
                g.setColor(ColorAdaptor.ChangeColor(shape, 'p'));
                g.fillRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                break;
            case OUTLINE:
                g.setColor(ColorAdaptor.ChangeColor(shape, 'p'));
                g.drawRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                break;
            case OUTLINE_AND_FILLED_IN:
                g.setColor(ColorAdaptor.ChangeColor(shape, 'p'));
                g.fillRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                g.setColor(ColorAdaptor.ChangeColor(shape, 's'));
                g.drawRect(shape.getDimensions().getStartX(), shape.getDimensions().getStartY(), shape.getDimensions().getWidth(), shape.getDimensions().getHeight());
                break;
        }
    }
}
