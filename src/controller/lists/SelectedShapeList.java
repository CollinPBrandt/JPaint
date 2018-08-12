package controller.lists;

import controller.interfaces.IList;
import model.shapes.data.ShapeObject;
import java.util.ArrayList;
import java.util.List;

public class SelectedShapeList implements IList {

    private List<ShapeObject> selectedList = new ArrayList<>();

    public void addShape(ShapeObject shape) {
        selectedList.add(shape);
    }

    public List<ShapeObject> getList(){return selectedList;}

    public void removeShape(ShapeObject shape){selectedList.remove(shape);}

}
