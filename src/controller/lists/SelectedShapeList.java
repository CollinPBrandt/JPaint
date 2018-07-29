package controller.lists;

import model.shapes.shapeData.ShapeObject;

import java.util.ArrayList;
import java.util.List;

public class SelectedShapeList {

    private List<ShapeObject> selectedList = new ArrayList<>();

    public void addShape(ShapeObject shape) {
        selectedList.add(shape);
    }

    public List<ShapeObject> getList(){return selectedList;}

    public void removeShape(ShapeObject shape){selectedList.remove(shape);}

}
