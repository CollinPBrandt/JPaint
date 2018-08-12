package model.persistence.lists;

import model.interfaces.IList;
import model.shapes.shapedata.ShapeObject;

import java.util.ArrayList;
import java.util.List;

public class ClipBoardList implements IList {

    private List<ShapeObject> clipBoard = new ArrayList<>();

    public void addShape(ShapeObject shape) {
        clipBoard.add(shape);
    }

    public List<ShapeObject> getList(){return clipBoard;}

    public void removeShape(ShapeObject shape){clipBoard.remove(shape);}
}
