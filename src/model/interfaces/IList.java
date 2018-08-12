package model.interfaces;

import model.shapes.shapedata.ShapeObject;
import java.util.List;

public interface IList {

    void addShape(ShapeObject shape);

    void removeShape(ShapeObject shape);

    List<ShapeObject> getList();

}
