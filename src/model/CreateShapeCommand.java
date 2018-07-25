package model;

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
        //Graphics shape = canvas.getGraphics2D();
        //shape.drawOval(start.x, start.y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
        ShapeConfiguration shapeConfig = appState.getCurrentShapeConfiguration();
        ShapeObject shape = new ShapeObject(start, end, shapeConfig);
        shapeList.addShape(shape);




       /* switch(shapeConfig.getShapeType()) {
            case ELLIPSE:
                ShapeObject shape = new ShapeObject(start, end, shapeConfig);
                break;
            case RECTANGLE:
                RectangleObject shape = new RectangleObject(canvas);
                break;
            case TRIANGLE:
                TriangleObject shape = new TriangleObject(canvas);
                break;
            default:
                break;
        }*/

    }
}
