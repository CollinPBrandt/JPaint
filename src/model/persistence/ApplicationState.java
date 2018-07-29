package model.persistence;

import controller.lists.ShapeListManager;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import model.shapes.data.ShapeConfiguration;
import model.shapes.enums.ShapeColor;
import model.shapes.enums.ShapeShadingType;
import model.shapes.enums.ShapeType;
import model.shapes.enums.StartAndEndPointMode;
import view.interfaces.IUiModule;

public class ApplicationState implements IApplicationState {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;
    private ShapeListManager shapeListManager;

    public ApplicationState(IUiModule uiModule, ShapeListManager shapeListManager) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        this.shapeListManager = shapeListManager;
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    public ShapeListManager getShapeListManager(){return shapeListManager;}

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    public ShapeConfiguration getCurrentShapeConfiguration(){
        ShapeConfiguration shapeConfig = new ShapeConfiguration();
        shapeConfig.setShapeType(getActiveShapeType());
        shapeConfig.setShapePrimaryColor(getActivePrimaryColor());
        shapeConfig.setShapeSecondaryColor(getActiveSecondaryColor());
        shapeConfig.setShapeShadingType(getActiveShapeShadingType());
        return shapeConfig;
    }

    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }
}
