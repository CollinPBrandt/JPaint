package controller.commands;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.shapes.data.ShapeObject;
import model.shapes.enums.ShapeColor;

public class ChangeSecondaryColorCommand implements ICommand{

    private IApplicationState applicationState;

    public ChangeSecondaryColorCommand(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        changeSecondaryColor();
    }

    /*Get active secondary color; change selected shape colors; notify; observers to redraw canvas*/
    private void changeSecondaryColor(){
        ShapeColor color  = applicationState.getActiveSecondaryColor();
        for(ShapeObject shape : applicationState.getShapeListManager().getSelectedShapeListObject().getList()){
            shape.setShapeSecondaryColor(color);
        }
        applicationState.getShapeListManager().getShapeListObject().notifyObservers();
    }
}