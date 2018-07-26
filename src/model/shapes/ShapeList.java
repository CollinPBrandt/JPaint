package model.shapes;

import model.interfaces.IDraw;
import view.gui.PaintCanvas;
import java.util.ArrayList;
import java.util.List;

public class ShapeList {

    private PaintCanvas canvas;

    public List<ShapeObject> shapeList = new ArrayList<>();

    public ShapeList(PaintCanvas canvas) {
        this.canvas = canvas;
    }

    public void addShape(ShapeObject shape) {
        shapeList.add(shape);
        drawShape();
    }


    public void drawShape() {
        for(ShapeObject shape : shapeList){

            IDraw drawStrategy;

            switch (shape.getShapeType()) {
                case ELLIPSE:
                    drawStrategy = new EllipseDraw();
                    drawStrategy.draw(shape, canvas);
                    break;
                case RECTANGLE:
                    drawStrategy = new RectangleDraw();
                    drawStrategy.draw(shape, canvas);
                    break;
                case TRIANGLE:
                    drawStrategy = new TriangleDraw();
                    drawStrategy.draw(shape, canvas);
                    break;
                default:
                    break;
            }
        }
    }
}
