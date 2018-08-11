package controller.commands;

import controller.lists.ShapeListManager;
import model.interfaces.ICommand;
import model.shapes.data.ShapeObject;

public class CopyCommand implements ICommand {

    private ShapeListManager shapeListManager;

    public CopyCommand(ShapeListManager shapeListManager) {
        this.shapeListManager = shapeListManager;
    }

    @Override
    /*Clear clipBoardList and then fill it with the shapes in selectedShapeList*/
    public void execute() {
        shapeListManager.getClipBoardListObject().getList().clear();
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            shapeListManager.getClipBoardListObject().addShape(shape);
        }
    }
}
