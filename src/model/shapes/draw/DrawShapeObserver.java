package model.shapes.draw;

import model.interfaces.IDrawStrategy;
import model.interfaces.IShapeObserver;
import controller.lists.ShapeList;
import model.shapes.data.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public class DrawShapeObserver implements IShapeObserver {

    private ShapeList shapeList;
    private PaintCanvas canvas;
    private IDrawStrategy drawStrategy;

    public DrawShapeObserver(ShapeList shapeList, PaintCanvas canvas){
        this.shapeList = shapeList;
        this.canvas = canvas;
        this.shapeList.registerObserver(this);
    }

    /*Draw white rectangle over canvas to clear (worst paint application ever)*/
    private void clearCanvas(){
        Graphics whiteRecForClearing = canvas.getGraphics2D();
        whiteRecForClearing.setColor(Color.white);
        whiteRecForClearing.fillRect(0,0, 1200, 800);
    }

    @Override
    /*Observer updated when ShapeList(subject) is changed. Iterates through shapeList and draws each*/
    public void update() {
        clearCanvas();
        for (ShapeObject shape : shapeList.getList()) {
            setDrawStrategy(shape);
            drawDrawStrategy();
        }
    }

    /*sets drawStrategy according to the shapeType of parameter shape*/
    private IDrawStrategy setDrawStrategy(ShapeObject shape) {
        switch (shape.getShapeType()) {
            case ELLIPSE:
                drawStrategy = new EllipseDrawStrategy(shape, canvas);
                break;
            case RECTANGLE:
                drawStrategy = new RectangleDrawStrategy(shape, canvas);
                break;
            case TRIANGLE:
                drawStrategy = new TriangleDrawStrategy(shape, canvas);
                break;
        }
        return drawStrategy;
    }

    /*Draws each shape according to algorithm outlined in each IDrawStrategy*/
    private void drawDrawStrategy(){
        drawStrategy.paint();
    }

}
