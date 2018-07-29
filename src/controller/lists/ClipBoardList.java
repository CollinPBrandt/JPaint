package controller.lists;

import model.shapes.shapeData.ShapeObject;

import java.util.ArrayList;
import java.util.List;

public class ClipBoardList {

    private List<ShapeObject> clipBoard = new ArrayList<>();

    public void addShape(ShapeObject shape) {
        clipBoard.add(shape);
    }

    public List<ShapeObject> getList(){return clipBoard;}

    public void removeShape(ShapeObject shape){clipBoard.remove(shape);}
}
