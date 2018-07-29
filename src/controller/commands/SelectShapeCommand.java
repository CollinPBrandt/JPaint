package controller.commands;

import model.interfaces.ICommand;
import controller.lists.SelectedShapeList;
import model.shapes.shapeData.ShapeObject;
import view.mouse.MouseDragDimensions;
import controller.lists.ShapeList;

public class SelectShapeCommand implements ICommand {

    private ShapeList shapeList;
    private MouseDragDimensions selectDimensions;
    private SelectedShapeList selectedShapeList;

    public SelectShapeCommand(MouseDragDimensions selectDimensions, ShapeList shapeList, SelectedShapeList selectedShapeList) {
        this.shapeList = shapeList;
        this.selectDimensions = selectDimensions;
        this.selectedShapeList = selectedShapeList;
    }

    public void findSelectedShapes(){
        for(ShapeObject shape : shapeList.getList()){
            if (shape.getDimensions().getStartX() >= selectDimensions.getStartX() &&
                shape.getDimensions().getStartY() >= selectDimensions.getStartY() &&
                shape.getDimensions().getStartX() + shape.getDimensions().getWidth() <= selectDimensions.getStartX() + selectDimensions.getWidth() &&
                shape.getDimensions().getStartY() + shape.getDimensions().getHeight() <= selectDimensions.getStartY() + selectDimensions.getHeight())
                {selectedShapeList.addShape(shape);
            }
        }
    }

    public void removeSelectedShapes(){
        selectedShapeList.getList().clear();
    }

    @Override
    public void execute() {
        removeSelectedShapes();
        findSelectedShapes();
    }
}
