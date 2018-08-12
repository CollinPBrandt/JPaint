package controller.commands;

import controller.interfaces.IUndoable;
import model.persistence.lists.ShapeListManager;
import controller.interfaces.ICommand;
import model.shapes.shapedata.ShapeObject;

public class DeleteCommand implements ICommand, IUndoable {

    private ShapeListManager shapeListManager;

    public DeleteCommand(ShapeListManager shapeListManager){
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void execute() {
        deleteShape();
        CommandHistory.add(this);
    }

    private void deleteShape(){
        /*Iterate over selected shapes and remove each shape from shapeList*/
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            shapeListManager.getShapeListObject().removeShape(shape);
        }
    }

    @Override
    public void undo() {
        /*Iterate over selected shapes and add each shape to shapeList*/
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            shapeListManager.getShapeListObject().addShape(shape);
        }
    }

    @Override
    public void redo() {
        deleteShape();
    }
}
