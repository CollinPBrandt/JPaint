package model.interfaces;

import model.persistence.lists.ShapeListManager;
import model.shapes.enums.ShapeColor;
import model.shapes.enums.ShapeShadingType;
import model.shapes.enums.ShapeType;
import model.shapes.enums.StartAndEndPointMode;

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
