package controller.Commands;

import controller.IUndoable;
import controller.ShapeListManager;
import model.interfaces.ICommand;
import model.shapes.ShapeData.ShapeObject;
import view.Mouse.MouseDragDimensions;

import java.util.ArrayList;
import java.util.List;

public class PasteCommand implements ICommand, IUndoable {

    private ShapeListManager shapeListManager;
    private List<ShapeObject> originalShapesForUndo = new ArrayList<>();
    private List<ShapeObject> newShapesForUndo = new ArrayList<>();

    public PasteCommand(ShapeListManager shapeListManager) {
        this.shapeListManager =  shapeListManager;
    }

    @Override
    public void execute() {
        for(ShapeObject shape : shapeListManager.getClipBoardListObject().getList()){
            originalShapesForUndo.add(shape);
            ShapeObject newShape = new ShapeObject(new MouseDragDimensions(0,0, shape.getDimensions().getWidth(), shape.getDimensions().getHeight()), shape.getShapeConfig());
            newShapesForUndo.add(newShape);
            shapeListManager.getShapeListObject().addShape(newShape);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for(ShapeObject shape : newShapesForUndo){
            shapeListManager.getShapeListObject().removeShape(shape);
        }
    }

    @Override
    public void redo() {
        execute();
    }
}
