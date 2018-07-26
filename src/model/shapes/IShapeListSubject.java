package model.shapes;

public interface IShapeListSubject {

    void registerObserver(IShapeObserver shapeObserver);

    void removeObserver(IShapeObserver shapeObserver);

    void notifyObservers();
}
