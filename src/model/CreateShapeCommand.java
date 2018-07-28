package model;

import model.interfaces.ICommand;
import model.persistence.ApplicationState;
import model.shapes.ShapeConfiguration;
import model.shapes.ShapeList;
import model.shapes.ShapeObject;

public class CreateShapeCommand implements ICommand {

    private ShapeDimensions dimensions;
    private ApplicationState appState;
    private ShapeList shapeList;

    public CreateShapeCommand(ShapeDimensions dimensions, ApplicationState appState, ShapeList shapeList) {
        this.dimensions = dimensions;
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        ShapeConfiguration shapeConfig = appState.getCurrentShapeConfiguration();
        ShapeObject shape = new ShapeObject(dimensions, shapeConfig);
        shapeList.addShape(shape);

    }
}
