package controller.Commands;

import model.interfaces.ICommand;
import model.shapes.SelectedShapeList;
import model.shapes.ShapeData.ShapeObject;
import view.Mouse.MouseDragDimensions;
import model.shapes.ShapeData.ShapeList;

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
