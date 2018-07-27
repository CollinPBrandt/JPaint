package model.interfaces;

import model.shapes.ShapeEnums.ShapeColor;
import model.shapes.ShapeEnums.ShapeShadingType;
import model.shapes.ShapeEnums.ShapeType;
import model.shapes.ShapeEnums.StartAndEndPointMode;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();
}
