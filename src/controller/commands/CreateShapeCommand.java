package controller.commands;

import controller.interfaces.IUndoable;
import model.persistence.lists.ShapeListManager;
import view.mouse.MouseDragDimensions;
import controller.interfaces.ICommand;
import model.persistence.ApplicationState;
import model.shapes.shapedata.ShapeConfiguration;
import model.persistence.lists.ShapeList;
import model.shapes.shapedata.ShapeObject;

public class CreateShapeCommand implements ICommand, IUndoable {

    private MouseDragDimensions dimensions;
    private ApplicationState appState;
    private ShapeList shapeList;
    private ShapeObject shape;

    public CreateShapeCommand(MouseDragDimensions dimensions, ApplicationState appState, ShapeListManager shapeListManager) {
        this.dimensions = dimensions;
        this.appState = appState;
        this.shapeList = shapeListManager.getShapeListObject();
    }

    @Override
    public void execute() {
        createShape();
        CommandHistory.add(this);
    }

    /*Get shape config, create new shape with that config and dimensions passed into object, and add shape to shapeList*/
    private void createShape(){
        ShapeConfiguration shapeConfig = appState.getCurrentShapeConfiguration();
        shape = new ShapeObject(dimensions, shapeConfig);
        shapeList.addShape(shape);
    }

    @Override
    public void undo() {
        shapeList.removeShape(shape);
    }

    @Override
    public void redo() {
        createShape();
    }
}
