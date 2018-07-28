package model.shapes;

import model.shapes.ShapeData.ShapeObject;

import java.util.ArrayList;
import java.util.List;

public class SelectedShapeList {

    private List<ShapeObject> selectedList = new ArrayList<>();

    public void addShape(ShapeObject shape) {
        selectedList.add(shape);
    }

    public List<ShapeObject> getList(){return selectedList;}

}
