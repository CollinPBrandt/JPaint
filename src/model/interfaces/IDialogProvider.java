package model.interfaces;

import model.shapes.ShapeEnums.ShapeColor;
import model.shapes.ShapeEnums.ShapeShadingType;
import model.shapes.ShapeEnums.ShapeType;
import model.shapes.ShapeEnums.StartAndEndPointMode;
import view.interfaces.IDialogChoice;

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ShapeColor> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColor> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog();

    IDialogChoice<StartAndEndPointMode> getChooseStartAndEndPointModeDialog();
}
