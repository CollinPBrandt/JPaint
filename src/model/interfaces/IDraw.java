package model.interfaces;

import model.shapes.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.*;

public interface IDraw {

    void draw(ShapeObject shape, PaintCanvas canvas, Graphics g);

    void paint(Graphics g);
}
