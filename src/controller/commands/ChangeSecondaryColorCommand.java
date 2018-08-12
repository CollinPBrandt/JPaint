package controller.commands;

import controller.interfaces.IUndoable;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.shapes.data.ShapeObject;
import model.shapes.enums.ShapeColor;

import java.util.ArrayList;
import java.util.List;

public class ChangeSecondaryColorCommand implements ICommand, IUndoable {

    private IApplicationState applicationState;
    private List<ShapeColor> originalColors = new ArrayList();

    public ChangeSecondaryColorCommand(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        changeSecondaryColor();
        CommandHistory.add(this);
    }

    /*Get active secondary color; save the original color of every selected shape; change selected shape colors; notify
     * observers to redraw canvas*/
    private void changeSecondaryColor(){
        ShapeColor color  = applicationState.getActiveSecondaryColor();
        for(ShapeObject shape : applicationState.getShapeListManager().getSelectedShapeListObject().getList()){
            originalColors.add(shape.getShapeSecondaryColor());
            shape.setShapeSecondaryColor(color);
        }
        applicationState.getShapeListManager().getShapeListObject().notifyObservers();
    }


    @Override
    /*iterate over selected shapes and set color to those saved in OriginalColors array*/
    public void undo() {
        for(int i = 0 ; i<applicationState.getShapeListManager().getSelectedShapeListObject().getList().size(); i++){
            ShapeObject shape = applicationState.getShapeListManager().getSelectedShapeListObject().getList().get(i);
            shape.setShapeSecondaryColor(originalColors.get(i));
        }
        applicationState.getShapeListManager().getShapeListObject().notifyObservers();
    }

    @Override
    public void redo() {
        execute();
    }
}
