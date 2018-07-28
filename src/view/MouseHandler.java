package view;

import controller.Commands.CreateShapeCommand;
import controller.Commands.MoveShapeCommand;
import controller.Commands.SelectShapeCommand;
import model.interfaces.ICommand;
import model.interfaces.IShapeObserver;
import model.persistence.ApplicationState;
import model.shapes.DrawShapes.DrawShapeObserver;
import model.shapes.ShapeData.ShapeDimensions;
import model.shapes.ShapeData.ShapeList;
import view.gui.PaintCanvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private int startX;
    private int startY;
    private int width;
    private int height;
    private ICommand command;
    private ApplicationState appState;
    private PaintCanvas canvas;
    private ShapeList shapeList;

    public MouseHandler(PaintCanvas canvas, ApplicationState appState){
        this.canvas = canvas;
        this.appState = appState;
        shapeList = new ShapeList();
        IShapeObserver shapeObserver = new DrawShapeObserver(shapeList, canvas); //will self register to shapeList
    }

    private void setCommand() {
        switch (appState.getActiveStartAndEndPointMode()) {
            case DRAW:
                this.command = new CreateShapeCommand(new ShapeDimensions(startX, startY, width, height), appState, shapeList);
                break;
            case SELECT:
                this.command = new SelectShapeCommand(new ShapeDimensions(startX, startY, width, height), canvas);
                break;
            case MOVE:
                this.command = new MoveShapeCommand(new ShapeDimensions(startX, startY, width, height), canvas);
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int endX = e.getX();
        int endY = e.getY();
        int tempX;
        int tempY;

        if(startX > endX) {
            tempX = startX;
            startX = endX;
            endX = tempX;
        }
        if(startY > endY){
            tempY = startY;
            startY = endY;
            endY = tempY;
        }

        width = endX - startX;
        height = endY - startY;

        setCommand();
        command.execute();
    }
}
