package controller.commands;

import model.interfaces.IList;
import model.persistence.lists.ShapeListManager;
import controller.interfaces.ICommand;
import model.shapes.shapedata.ShapeObject;
import view.mouse.MouseDragDimensions;
import model.persistence.lists.ShapeList;

public class SelectShapeCommand implements ICommand {

    private ShapeList shapeList;
    private MouseDragDimensions selectDimensions;
    private IList selectedShapeList;

    public SelectShapeCommand(MouseDragDimensions selectDimensions, ShapeListManager shapeListManager) {
        this.selectDimensions = selectDimensions;
        this.shapeList = shapeListManager.getShapeListObject();
        this.selectedShapeList = shapeListManager.getSelectedShapeListObject();
    }

    public void findSelectedShapes(){
        for(ShapeObject shape : shapeList.getList()){
            if (shape.getDimensions().getStartX()+ shape.getDimensions().getWidth()
                    >= selectDimensions.getStartX() && //if select x is to left(lower x val) of shape
                shape.getDimensions().getStartY()+ shape.getDimensions().getWidth()
                        >= selectDimensions.getStartY() &&//if select y is above(lower y val) of shape
                shape.getDimensions().getStartX() <= selectDimensions.getStartX()
                        + selectDimensions.getWidth() && //if select release is to right(higher x val) of shape
                shape.getDimensions().getStartY() <= selectDimensions.getStartY()
                        + selectDimensions.getHeight()) //if select release is to below(higher x val) of shape
                //if the selectDimensions touch a shape(or the rectangle around it) then add it to selectList
                {selectedShapeList.addShape(shape); }
        }
    }

    private void removeSelectedShapes(){
        selectedShapeList.getList().clear();
    }

    @Override
    /*before executing command, clear selectedShapeList*/
    public void execute() {
        removeSelectedShapes();
        findSelectedShapes();
    }
}
