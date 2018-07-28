/*package controller;

import model.interfaces.ICommand;
import model.shapes.ShapeData.ShapeObject;

public class DeleteCommand implements ICommand {

    private ShapeListManager shapeListManager;

    public DeleteCommand(ShapeListManager shapeListManager){
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void execute() {
        for(ShapeObject shape : shapeListManager.getSelectedShapeListObject().getList()){
            shapeListManager.getShapeListObject().removeShape(shape);
        }
    }
}*/
