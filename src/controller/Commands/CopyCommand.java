package controller.Commands;

import controller.ShapeListManager;
import model.interfaces.ICommand;
import model.shapes.ShapeData.ShapeObject;

public class CopyCommand implements ICommand {

    private ShapeListManager shapeListManager;

    public CopyCommand(ShapeListManager shapeListManager) {
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void execute() {
        //shapeListManager.getClipBoardListObject().getList().clear();
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            shapeListManager.getClipBoardListObject().addShape(shape);
        }
    }
}
