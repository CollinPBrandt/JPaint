package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.interfaces.IShapeObserver;
import model.shapes.ColorAdaptor;
import model.shapes.ShapeList;
import model.shapes.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class DrawShapeObserver implements IShapeObserver {

    private ShapeList shapeList;
    private Graphics g;
    private PaintCanvas canvas;

    public DrawShapeObserver(ShapeList shapeList, PaintCanvas canvas){
        this.shapeList = shapeList;
        this.g = canvas.getGraphics2D();
        this.canvas = canvas;
        this.shapeList.registerObserver(this);
    }

    @Override
    public void update() {
        for(ShapeObject shape : shapeList.getList()){
            g.setColor(ColorAdaptor.ChangeColor(shape, 'p'));
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
            canvas.paint(g);
        }
    }
}
