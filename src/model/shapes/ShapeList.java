package model.shapes;

import view.gui.PaintCanvas;
import java.util.ArrayList;
import java.util.List;

public class ShapeList implements IShapeListSubject{

    public List<ShapeObject> shapelist = new ArrayList<>();
    public List<IShapeObserver> shapeObservers = new ArrayList<>();

    public ShapeList(PaintCanvas canvas) {
        new DrawShapeObserver(this, canvas);
    }

    public void addShape(ShapeObject shape) {
        shapelist.add(shape);
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
