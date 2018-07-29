package controller.Commands;

import controller.ShapeListManager;
import model.shapes.SelectedShapeList;
import model.shapes.ShapeData.ShapeObject;
import view.Mouse.MouseDragDimensions;
import model.interfaces.ICommand;

public class MoveShapeCommand implements ICommand {

    private MouseDragDimensions dimensions;
    private ShapeListManager shapeListManager;
    private boolean draggedRight;
    private boolean draggedDown;

    public MoveShapeCommand(MouseDragDimensions dimensions, boolean draggedRight, boolean draggedDown, ShapeListManager shapeListManager) {
        this.dimensions = dimensions;
        this.shapeListManager = shapeListManager;
        this.draggedRight = draggedRight;
        this.draggedDown = draggedDown;
    }

    @Override
    public void execute() {
        moveShape();
    }

    private void moveShape(){
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            if(draggedRight && draggedDown){
                shape.changeShapeStart(
                        shape.getDimensions().getStartX() + dimensions.getWidth(),
                        shape.getDimensions().getStartY() + dimensions.getHeight());
            }
            else if(draggedRight){
                shape.changeShapeStart(
                        shape.getDimensions().getStartX() + dimensions.getWidth(),
                        shape.getDimensions().getStartY() - dimensions.getHeight());
            }

            else if(draggedDown){
                shape.changeShapeStart(
                        shape.getDimensions().getStartX() - dimensions.getWidth(),
                        shape.getDimensions().getStartY() + dimensions.getHeight());
            }

            else{
                shape.changeShapeStart(
                        shape.getDimensions().getStartX() - dimensions.getWidth(),
                        shape.getDimensions().getStartY() - dimensions.getHeight());
            }
        }
        shapeListManager.getShapeListObject().notifyObservers();    //clear and redraw everything after move
    }
}
