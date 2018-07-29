package controller;

import model.interfaces.ICommand;
import model.shapes.ShapeData.ShapeObject;

public class CopyCommand implements ICommand {

    private ShapeListManager shapeListManager;

    public CopyCommand(ShapeListManager shapeListManager) {
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void execute() {
        for(ShapeObject shape : shapeListManager.getClipBoardListObject().getList()){
            shapeListManager.getClipBoardListObject().addShape(shape);
        }
    }
}
