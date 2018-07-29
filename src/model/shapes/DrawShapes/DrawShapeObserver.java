package model.shapes.DrawShapes;

import model.interfaces.IDraw;
import model.interfaces.IShapeObserver;
import model.shapes.ShapeData.ShapeList;
import model.shapes.ShapeData.ShapeObject;
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

    private void clearCanvas(){
        Graphics whiteRecForClearing = canvas.getGraphics2D();  //draw white rectangle over canvas to clear
        whiteRecForClearing.setColor(Color.white);
        whiteRecForClearing.fillRect(0,0, 1200, 800);
    }

    @Override
    public void update() {
        clearCanvas();
        for(ShapeObject shape : shapeList.getList()){
            IDraw drawStrategy;
            switch (shape.getShapeType()) {
                case ELLIPSE:
                    drawStrategy = new EllipseDraw(shape, canvas, g);
                    drawStrategy.paint(g);
                    break;
                case RECTANGLE:
                    drawStrategy = new RectangleDraw(shape, canvas, g);
                    drawStrategy.paint(g);
                    break;
                case TRIANGLE:
                    drawStrategy = new TriangleDraw(shape, canvas, g);
                    drawStrategy.paint(g);
                    break;
                default:
                    break;
            }
        }
    }
}
