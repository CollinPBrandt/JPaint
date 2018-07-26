package model;

import model.interfaces.ICommand;
import model.persistence.ApplicationState;
import model.shapes.ShapeConfiguration;
import model.shapes.ShapeList;
import model.shapes.ShapeObject;

public class CreateShapeCommand implements ICommand {

    private Pair start;
    private Pair end;
    private ApplicationState appState;
    private ShapeList shapeList;

    public CreateShapeCommand(Pair start, Pair end, ApplicationState appState, ShapeList shapeList) {
        this.start = start;
        this.end = end;
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        ShapeConfiguration shapeConfig = appState.getCurrentShapeConfiguration();
        ShapeObject shape = new ShapeObject(start, end, shapeConfig);
        shapeList.addShape(shape);

    }
}
