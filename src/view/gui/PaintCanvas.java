package view.gui;

import model.shapes.ShapeList;
import model.shapes.ShapeObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintCanvas extends JComponent {

    private ShapeList shapeListObject = new ShapeList(new ArrayList<>());

    public void addShapeToDraw(ShapeObject shape){
        shapeListObject.addShape(shape);
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        for(ShapeObject shape : shapeListObject.shapeList) {
            shape.draw(g);
        }
    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
