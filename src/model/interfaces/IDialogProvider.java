package model.interfaces;

import model.shapes.ShapeColor;
import model.shapes.ShapeShadingType;
import model.shapes.ShapeType;
import model.shapes.StartAndEndPointMode;
import view.interfaces.IDialogChoice;

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ShapeColor> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColor> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog();

    IDialogChoice<StartAndEndPointMode> getChooseStartAndEndPointModeDialog();
}
