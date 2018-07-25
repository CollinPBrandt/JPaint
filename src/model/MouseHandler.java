package model;

import model.shapes.ShapeObject;
import view.gui.PaintCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    public Pair start;
    public Pair end;
    private PaintCanvas canvas;

    public MouseHandler(PaintCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        start = new Pair(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        end = new Pair(e.getX(), e.getY());
        canvas.addShapeToDraw(new ShapeObject(start.x, start.y, Math.abs(start.x - end.x), Math.abs(start.y - end.y)));
    }
}
