package controller.commands;

import controller.interfaces.IUndoable;
import model.persistence.lists.ShapeListManager;
import controller.interfaces.ICommand;
import model.shapes.shapedata.ShapeObject;
import view.mouse.MouseDragDimensions;

import java.util.ArrayList;
import java.util.List;

public class PasteCommand implements ICommand, IUndoable {

    private ShapeListManager shapeListManager;
    private List<ShapeObject> newShapesForUndo = new ArrayList<>();

    public PasteCommand(ShapeListManager shapeListManager) {
        this.shapeListManager =  shapeListManager;
    }

    @Override
    public void execute() {
        pasteShape();
        CommandHistory.add(this);
    }

    /*iterate over clipboard and creates a new shape for each copied shape. Adds those new shapes to newShapesForUndo to
     *keep track of last pasted shapes as any new copy will clear clipboard making undo impossible. Pastes to origin*/
    private void pasteShape(){
        for(ShapeObject shape : shapeListManager.getClipBoardListObject().getList()){
            ShapeObject newShape = new ShapeObject(new MouseDragDimensions(0,0, shape.getDimensions().getWidth(), shape.getDimensions().getHeight()), shape.getShapeConfig());
            newShapesForUndo.add(newShape);
            shapeListManager.getShapeListObject().addShape(newShape);
        }
    }

    @Override
    /*iterate over the last shapes that were copied and remove them from shapelist*/
    public void undo() {
        for(ShapeObject shape : newShapesForUndo){
            shapeListManager.getShapeListObject().removeShape(shape);
        }
    }

    @Override
    public void redo() {
        pasteShape();
    }
}
