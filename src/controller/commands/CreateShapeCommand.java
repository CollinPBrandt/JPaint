package controller.commands;

import controller.interfaces.IUndoable;
import controller.lists.ShapeListManager;
import view.mouse.MouseDragDimensions;
import model.interfaces.ICommand;
import model.persistence.ApplicationState;
import model.shapes.data.ShapeConfiguration;
import controller.lists.ShapeList;
import model.shapes.data.ShapeObject;

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
    /*Get shape config, create new shape with that config and dimensions passed into object, and add shape to shapeList*/
    public void execute() {
        ShapeConfiguration shapeConfig = appState.getCurrentShapeConfiguration();
        shape = new ShapeObject(dimensions, shapeConfig);
        shapeList.addShape(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.removeShape(shape);
    }

    @Override
    public void redo() {
        execute();

    }
}
