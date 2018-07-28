package model.shapes;

import model.ShapeDimensions;
import model.shapes.ShapeEnums.ShapeColor;
import model.shapes.ShapeEnums.ShapeShadingType;
import model.shapes.ShapeEnums.ShapeType;

public class ShapeObject {

    private ShapeDimensions dimensions;
    private ShapeConfiguration shapeConfig;
    private ShapeType shapeType;
    private ShapeColor shapePrimaryColor;
    private ShapeColor shapeSecondaryColor;
    private ShapeShadingType shapeShadingType;

    public ShapeObject(ShapeDimensions dimensions, ShapeConfiguration shapeConfig) {
        this.dimensions = dimensions;
        this.shapeConfig = shapeConfig;
        this.shapeType = shapeConfig.getShapeType();
        this.shapePrimaryColor = shapeConfig.getShapePrimaryColor();
        this.shapeSecondaryColor = shapeConfig.getShapeSecondaryColor();
        this.shapeShadingType = shapeConfig.getShapeShadingType();
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public ShapeDimensions getDimensions() {return dimensions;}

    public ShapeColor getShapePrimaryColor() { return shapePrimaryColor; }

    public ShapeColor getShapeSecondaryColor(){ return shapeSecondaryColor; }
}
