package controller.commands;

import controller.lists.ShapeListManager;
import model.interfaces.ICommand;
import model.shapes.shapeData.ShapeObject;

public class CopyCommand implements ICommand {

    private ShapeListManager shapeListManager;

    public CopyCommand(ShapeListManager shapeListManager) {
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void execute() {
        shapeListManager.getClipBoardListObject().getList().clear();
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            shapeListManager.getClipBoardListObject().addShape(shape);
        }
    }
}
