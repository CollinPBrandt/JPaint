package view.mouse;

import controller.commands.CreateShapeCommand;
import controller.commands.MoveShapeCommand;
import controller.commands.SelectShapeCommand;
import model.persistence.lists.ShapeListManager;
import controller.interfaces.ICommand;
import model.persistence.ApplicationState;
import model.shapes.drawStrategy.DrawShapeObserver;
import view.gui.PaintCanvas;

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
    private ShapeListManager shapeListManager;

    public MouseHandler(PaintCanvas canvas, ApplicationState appState){
        this.appState = appState;
        this.shapeListManager = appState.getShapeListManager();
        //Observer of ShapeList that will self register to shapeList
        new DrawShapeObserver(shapeListManager.getShapeListObject(), canvas);
    }

    /*Set ICommand to concrete command according to the application state's ActiveStartAndEndPointMode*/
    private void setCommand() {
        switch (appState.getActiveStartAndEndPointMode()) {
            case DRAW:
                command = new CreateShapeCommand(new MouseDragDimensions(startX, startY, width, height), appState, shapeListManager);
                break;
            case SELECT:
                command = new SelectShapeCommand(new MouseDragDimensions(startX, startY, width, height), shapeListManager);
                break;
            case MOVE:
                command = new MoveShapeCommand(new MouseDragDimensions(startX, startY, width, height), dragDirectionRight, dragDirectionDown, shapeListManager);
                break;
        }
    }

    private void invoker(){
        command.execute();
    }


    @Override
    /*Gets the X and Y coordinates of where the mouse was first clicked and held*/
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    /*Gets X and Y coordinates of where mouse is released and calculates the difference between
    * released and first pressed to get Height and Width. Then sets flags to determine direction
    * of drag and each shape start/end set as if dragged top left to bottom right. Sets and calls
    * command after setting these variables*/
    public void mouseReleased(MouseEvent e) {
        //released coordinates
        int endX = e.getX();
        int endY = e.getY();
        int tempX;
        int tempY;
        //drag direction flags
        dragDirectionRight = true;
        dragDirectionDown = true;
        //determine horizontal drag direction
        if(startX > endX) {
            tempX = startX;
            startX = endX;
            endX = tempX;
            dragDirectionRight = false;
        }//determine vertical drag direction
        if(startY > endY){
            tempY = startY;
            startY = endY;
            endY = tempY;
            dragDirectionDown = false;
        }//set height and width
        width = endX - startX;
        height = endY - startY;

        //set command and execute it
        setCommand();
        invoker();
    }
}
