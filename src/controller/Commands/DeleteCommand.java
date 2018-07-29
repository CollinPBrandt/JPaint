package controller.Commands;

import controller.IUndoable;
import controller.ShapeListManager;
import model.interfaces.ICommand;
import model.shapes.ShapeData.ShapeObject;

public class DeleteCommand implements ICommand, IUndoable {

    private ShapeListManager shapeListManager;

    public DeleteCommand(ShapeListManager shapeListManager){
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void execute() {
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            shapeListManager.getShapeListObject().removeShape(shape);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            shapeListManager.getShapeListObject().addShape(shape);
        }
    }

    @Override
    public void redo() {
        execute();
    }
}
