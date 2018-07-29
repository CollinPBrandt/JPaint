package controller.Commands;

import controller.IUndoable;
import view.Mouse.MouseDragDimensions;
import model.interfaces.ICommand;
import model.persistence.ApplicationState;
import model.shapes.ShapeData.ShapeConfiguration;
import model.shapes.ShapeData.ShapeList;
import model.shapes.ShapeData.ShapeObject;

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
