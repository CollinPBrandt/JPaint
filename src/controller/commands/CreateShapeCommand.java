package controller.commands;

import controller.interfaces.IUndoable;
import view.mouse.MouseDragDimensions;
import model.interfaces.ICommand;
import model.persistence.ApplicationState;
import model.shapes.shapeData.ShapeConfiguration;
import controller.lists.ShapeList;
import model.shapes.shapeData.ShapeObject;

public class CreateShapeCommand implements ICommand, IUndoable {

    private MouseDragDimensions dimensions;
    private ApplicationState appState;
    private ShapeList shapeList;
    private ShapeObject shape;

    public CreateShapeCommand(MouseDragDimensions dimensions, ApplicationState appState, ShapeList shapeList) {
        this.dimensions = dimensions;
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
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
