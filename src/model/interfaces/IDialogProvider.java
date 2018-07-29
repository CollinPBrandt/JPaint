package model.interfaces;

import model.shapes.shapeEnums.ShapeColor;
import model.shapes.shapeEnums.ShapeShadingType;
import model.shapes.shapeEnums.ShapeType;
import model.shapes.shapeEnums.StartAndEndPointMode;
import view.interfaces.IDialogChoice;

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ShapeColor> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColor> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog();

    IDialogChoice<StartAndEndPointMode> getChooseStartAndEndPointModeDialog();
}
