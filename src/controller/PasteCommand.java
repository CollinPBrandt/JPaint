package controller;

import model.interfaces.ICommand;
import model.shapes.ShapeData.ShapeObject;

public class PasteCommand implements ICommand {

    private ShapeListManager shapeListManager;

    public PasteCommand(ShapeListManager shapeListManager) {
        this.shapeListManager =  shapeListManager;
    }

    @Override
    public void execute() {
        for(ShapeObject shape : shapeListManager.getClipBoardListObject().getList()){
            shape.getDimensions().setStartX(0);
            shape.getDimensions().setStartY(0);
            shapeListManager.getShapeListObject().addShape(shape);
        }
        shapeListManager.getClipBoardListObject().getList().clear();
    }
}
