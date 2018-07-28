package model.shapes.ShapeData;

import model.shapes.ShapeEnums.ShapeColor;
import model.shapes.ShapeEnums.ShapeShadingType;
import model.shapes.ShapeEnums.ShapeType;
import view.Mouse.MouseDragDimensions;

public class ShapeObject {

    private MouseDragDimensions dimensions;
    private ShapeConfiguration shapeConfig;
    private ShapeType shapeType;
    private ShapeColor shapePrimaryColor;
    private ShapeColor shapeSecondaryColor;
    private ShapeShadingType shapeShadingType;

    public ShapeObject(MouseDragDimensions dimensions, ShapeConfiguration shapeConfig) {
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

    public MouseDragDimensions getDimensions() {return dimensions;}

    public ShapeColor getShapePrimaryColor() { return shapePrimaryColor; }

    public ShapeColor getShapeSecondaryColor(){ return shapeSecondaryColor; }

    public void changeShapeStart(int newStartX, int newStartY){
        dimensions.setStartX(newStartX);
        dimensions.setStartY(newStartY);
    }
}
