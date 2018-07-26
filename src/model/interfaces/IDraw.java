package model.interfaces;

import model.shapes.ShapeObject;
import view.gui.PaintCanvas;

public interface IDraw {

    public void draw(ShapeObject shape, PaintCanvas canvas);

}
