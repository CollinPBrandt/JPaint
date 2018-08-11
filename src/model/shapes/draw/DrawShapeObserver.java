package model.shapes.draw;

import model.interfaces.IDraw;
import model.interfaces.IShapeObserver;
import controller.lists.ShapeList;
import model.shapes.data.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class DrawShapeObserver implements IShapeObserver {

    private ShapeList shapeList;
    private PaintCanvas canvas;

    public DrawShapeObserver(ShapeList shapeList, PaintCanvas canvas){
        this.shapeList = shapeList;
        this.canvas = canvas;
        this.shapeList.registerObserver(this);
    }

    private void clearCanvas(){
        //Draw white rectangle over canvas to clear
        Graphics whiteRecForClearing = canvas.getGraphics2D();
        whiteRecForClearing.setColor(Color.white);
        whiteRecForClearing.fillRect(0,0, 1200, 800);
    }

    @Override
    public void update() {
        clearCanvas();
        IDraw drawStrategy;
        for(ShapeObject shape : shapeList.getList()){
            switch (shape.getShapeType()) {
                case ELLIPSE:
                    drawStrategy = new EllipseDraw(shape, canvas);
                    break;
                case RECTANGLE:
                    drawStrategy = new RectangleDraw(shape, canvas);
                    break;
                case TRIANGLE:
                    drawStrategy = new TriangleDraw(shape, canvas);
                    break;
                default:
                    drawStrategy = new EllipseDraw(shape, canvas);   //default is to draw Ellipse
                    break;
            }
            drawStrategy.paint();
        }
    }
}
