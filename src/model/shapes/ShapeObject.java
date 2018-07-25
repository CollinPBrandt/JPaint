package model.shapes;

import model.Pair;

import java.awt.*;

public class ShapeObject {

    private Pair start;
    private Pair end;
    private ShapeConfiguration shapeConfig;
    private ShapeType shapeType;
    private ShapeColor shapePrimaryColor;
    private ShapeColor shapeSecondaryColor;
    private ShapeShadingType shapeShadingType;


    public ShapeObject(Pair start, Pair end, ShapeConfiguration shapeConfig) {
        this.start = start;
        this.end = end;
        this.shapeConfig = shapeConfig;
        this.shapeType = shapeConfig.getShapeType();
        this.shapePrimaryColor = shapeConfig.getShapePrimaryColor();
        this.shapeSecondaryColor = shapeConfig.getShapeSecondaryColor();
        this.shapeShadingType = shapeConfig.getShapeShadingType();
    }

    public void draw(){
        Graphics shape = canvas.getGraphics2D();
        shape.drawOval(start.x, start.y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
    }
}
