package model.shapes;

import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeList {

    private PaintCanvas canvas;
    Graphics g;
    public List<ShapeObject> shapeList = new ArrayList<>();

    public ShapeList(PaintCanvas canvas) {
        this.canvas = canvas;
        this.g = canvas.getGraphics2D();
    }

    public void addShape(ShapeObject shape) {
        shapeList.add(shape);
        drawShape();
        canvas.update(g);
    }


    public void drawShape() {
        for(ShapeObject shape : shapeList){
            g.setColor(ColorAdaptor.ChangeColor(shape));
            IDraw drawStrategy;

            switch (shape.getShapeType()) {
                case ELLIPSE:
                    drawStrategy = new EllipseDraw();
                    drawStrategy.draw(shape, canvas, g);
                    break;
                case RECTANGLE:
                    drawStrategy = new RectangleDraw();
                    drawStrategy.draw(shape, canvas, g);
                    break;
                case TRIANGLE:
                    drawStrategy = new TriangleDraw();
                    drawStrategy.draw(shape, canvas, g);
                    break;
                default:
                    break;
            }
        }
    }
}
