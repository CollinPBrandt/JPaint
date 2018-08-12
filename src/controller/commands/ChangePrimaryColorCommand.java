package controller.commands;

import controller.interfaces.IUndoable;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.shapes.data.ShapeObject;
import model.shapes.enums.ShapeColor;

import java.util.ArrayList;
import java.util.List;

public class ChangePrimaryColorCommand implements ICommand, IUndoable {

    private IApplicationState applicationState;
    private List<ShapeColor> originalColors = new ArrayList();

    public ChangePrimaryColorCommand(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        changePrimaryColor();
        CommandHistory.add(this);
    }

    /*Get active primary color; save the original color of every selected shape; change selected shape colors; notify
    * observers to redraw canvas*/
    private void changePrimaryColor(){
        ShapeColor color  = applicationState.getActivePrimaryColor();
        for(ShapeObject shape : applicationState.getShapeListManager().getSelectedShapeListObject().getList()){
            originalColors.add(shape.getShapePrimaryColor());
            shape.setShapePrimaryColor(color);
        }
        applicationState.getShapeListManager().getShapeListObject().notifyObservers();
    }


    @Override
    /*iterate over selected shapes and set color to those saved in OriginalColors array*/
    public void undo() {
        for(int i = 0 ; i<applicationState.getShapeListManager().getSelectedShapeListObject().getList().size(); i++){
            ShapeObject shape = applicationState.getShapeListManager().getSelectedShapeListObject().getList().get(i);
            shape.setShapePrimaryColor(originalColors.get(i));
        }
        applicationState.getShapeListManager().getShapeListObject().notifyObservers();
    }

    @Override
    public void redo() {
        changePrimaryColor();
    }
}
