package view.Mouse;

import controller.Commands.CreateShapeCommand;
import controller.Commands.MoveShapeCommand;
import controller.Commands.SelectShapeCommand;
import model.interfaces.ICommand;
import model.interfaces.IShapeObserver;
import model.persistence.ApplicationState;
import model.shapes.DrawShapes.DrawShapeObserver;
import model.shapes.SelectedShapeList;
import model.shapes.ShapeData.ShapeList;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private int startX;
    private int startY;
    private int width;
    private int height;
    private boolean dragDirectionRight;
    private boolean dragDirectionDown;
    private ICommand command;
    private ApplicationState appState;
    private PaintCanvas canvas;
    private ShapeList shapeList;
    private SelectedShapeList selectedShapeList;

    public MouseHandler(PaintCanvas canvas, ApplicationState appState){
        this.canvas = canvas;
        this.appState = appState;
        shapeList = new ShapeList();
        selectedShapeList = new SelectedShapeList();
        IShapeObserver shapeObserver = new DrawShapeObserver(shapeList, canvas); //will self register to shapeList
    }

    private void setCommand() {
        switch (appState.getActiveStartAndEndPointMode()) {
            case DRAW:
                this.command = new CreateShapeCommand(new MouseDragDimensions(startX, startY, width, height), appState, shapeList);
                break;
            case SELECT:
                this.command = new SelectShapeCommand(new MouseDragDimensions(startX, startY, width, height), shapeList, selectedShapeList);
                break;
            case MOVE:
                this.command = new MoveShapeCommand(new MouseDragDimensions(startX, startY, width, height), dragDirectionRight, dragDirectionDown, selectedShapeList);
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
        dragDirectionRight = true;
        dragDirectionDown = true;

        if(startX > endX) {
            tempX = startX;
            startX = endX;
            endX = tempX;
            dragDirectionRight = false;
        }
        if(startY > endY){
            tempY = startY;
            startY = endY;
            endY = tempY;
            dragDirectionDown = false;
        }

        width = endX - startX;
        height = endY - startY;

        setCommand();
        command.execute();

        Graphics whiteRecForClearing = canvas.getGraphics2D();  //draw white rectangle over canvas to clear
        whiteRecForClearing.setColor(Color.white);
        whiteRecForClearing.fillRect(0,0, 1200, 800);

        shapeList.notifyObservers();
    }
}
