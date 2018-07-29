package model.shapes.shapeData;

import model.shapes.shapeEnums.ShapeColor;
import model.shapes.shapeEnums.ShapeShadingType;
import model.shapes.shapeEnums.ShapeType;
import view.mouse.MouseDragDimensions;

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

    public ShapeConfiguration getShapeConfig(){return shapeConfig;}

    public void changeShapeStart(int newStartX, int newStartY){
        dimensions.setStartX(newStartX);
        dimensions.setStartY(newStartY);
    }

    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }
}
