package model.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeList {

    public List<ShapeObject> shapeList;

    public ShapeList(List<ShapeObject> shapeList) {
        this.shapeList = shapeList;
    }

    public void addShape(ShapeObject shape){
        shapeList.add(shape);
    }
}
