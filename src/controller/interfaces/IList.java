package controller.interfaces;

import model.shapes.data.ShapeObject;
import java.util.List;

public interface IList {

    void addShape(ShapeObject shape);

    void removeShape(ShapeObject shape);

    List<ShapeObject> getList();

}
