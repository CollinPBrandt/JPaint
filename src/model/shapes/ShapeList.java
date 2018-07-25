package model.shapes;

import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.List;

public class ShapeList {

    private PaintCanvas canvas;
    private ShapeDrawer drawer;
    public List<ShapeObject> shapeList = new ArrayList<>();

    public ShapeList(PaintCanvas canvas) {
        this.canvas = canvas;
        drawer = new ShapeDrawer(canvas, this);
    }

    public void addShape(ShapeObject shape) {
        shapeList.add(shape);
    }
}
