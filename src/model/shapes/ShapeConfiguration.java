package model.shapes;

import model.shapes.ShapeEnums.ShapeColor;
import model.shapes.ShapeEnums.ShapeShadingType;
import model.shapes.ShapeEnums.ShapeType;

public class ShapeConfiguration {

    private ShapeType shapeType;
    private ShapeColor shapePrimaryColor;
    private ShapeColor shapeSecondaryColor;
    private ShapeShadingType shapeShadingType;


    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public void setShapePrimaryColor(ShapeColor shapePrimaryColor) {
        this.shapePrimaryColor = shapePrimaryColor;
    }

    public void setShapeSecondaryColor(ShapeColor shapeSecondaryColor) {
        this.shapeSecondaryColor = shapeSecondaryColor;
    }

    public void setShapeShadingType(ShapeShadingType shapeShadingType) {
        this.shapeShadingType = shapeShadingType;
    }


    public ShapeType getShapeType() {
        return shapeType;
    }

    public ShapeColor getShapePrimaryColor() {
        return shapePrimaryColor;
    }

    public ShapeColor getShapeSecondaryColor() {
        return shapeSecondaryColor;
    }

    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }
}
