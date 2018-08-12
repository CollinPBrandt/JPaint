package controller.lists;

import controller.interfaces.IList;

public class ShapeListManager {
    private ShapeList shapeList;
    private IList selectedShapeList;
    private IList clipBoardList;

    public ShapeListManager() {
        shapeList = new ShapeList();
        selectedShapeList = new SelectedShapeList();
        clipBoardList = new ClipBoardList();
    }

    public ShapeList getShapeListObject() {
        return shapeList;
    }

    public IList getSelectedShapeListObject() {
        return selectedShapeList;
    }

    public IList getClipBoardListObject() {
        return clipBoardList;
    }
}
