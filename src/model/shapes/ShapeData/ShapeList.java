package model.shapes.ShapeData;

import model.interfaces.IShapeListSubject;
import model.interfaces.IShapeObserver;
import model.shapes.ShapeData.ShapeObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeList implements IShapeListSubject {

    private List<ShapeObject> shapelist = new ArrayList<>();
    private List<IShapeObserver> shapeObservers = new ArrayList<>();

    public List<ShapeObject> getList(){return shapelist;}

    public void addShape(ShapeObject shape) {
        shapelist.add(shape);
        notifyObservers();
    }

    public void removeShape(ShapeObject shape){
        shapelist.remove(shape);
        notifyObservers();
    }

    public void registerObserver(IShapeObserver shapeObserver){
        shapeObservers.add(shapeObserver);
    }

    public void removeObserver(IShapeObserver shapeObserver){
        shapeObservers.remove(shapeObserver);
    }

    public void notifyObservers(){
        for(IShapeObserver shapeObserver : shapeObservers){
            shapeObserver.update();
        }
    }

}
