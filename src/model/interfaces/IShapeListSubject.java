package model.interfaces;

public interface IShapeListSubject {

    void registerObserver(IShapeObserver shapeObserver);

    void removeObserver(IShapeObserver shapeObserver);

    void notifyObservers();
}
