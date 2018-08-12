package controller.commands;

import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.shapes.data.ShapeObject;
import model.shapes.enums.ShapeColor;

public class ChangePrimaryColorCommand implements ICommand {

    private IApplicationState applicationState;

    public ChangePrimaryColorCommand(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        changePrimaryColor();
    }

    /*Get active primary color; change selected shape colors; notify observers to redraw canvas*/
    private void changePrimaryColor(){
        ShapeColor color  = applicationState.getActivePrimaryColor();
        for(ShapeObject shape : applicationState.getShapeListManager().getSelectedShapeListObject().getList()){
            shape.setShapePrimaryColor(color);
        }
        applicationState.getShapeListManager().getShapeListObject().notifyObservers();
    }
}
