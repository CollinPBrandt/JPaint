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

    public ShapeType getShapeType() {
        return shapeType;
    }

    public Pair getStart() {
        return start;
    }

    public Pair getEnd() {
        return end;
    }
}
