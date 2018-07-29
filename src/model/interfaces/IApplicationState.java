package model.interfaces;

import controller.lists.ShapeListManager;
import model.shapes.shapeEnums.ShapeColor;
import model.shapes.shapeEnums.ShapeShadingType;
import model.shapes.shapeEnums.ShapeType;
import model.shapes.shapeEnums.StartAndEndPointMode;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeListManager getShapeListManager();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();
}
