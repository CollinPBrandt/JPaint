package controller;

import controller.commands.*;
import controller.interfaces.IJPaintController;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());

        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> {
            applicationState.setActivePrimaryColor();
            new ChangePrimaryColorCommand(applicationState).execute();
        });

        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> {
            applicationState.setActiveSecondaryColor();
            new ChangeSecondaryColorCommand(applicationState).execute();
        });

        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());

        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());

        uiModule.addEvent(EventName.DELETE, () -> new DeleteCommand(applicationState.getShapeListManager()).execute());

        uiModule.addEvent(EventName.COPY, () -> new CopyCommand(applicationState.getShapeListManager()).execute());

        uiModule.addEvent(EventName.PASTE, () -> new PasteCommand(applicationState.getShapeListManager()).execute());

        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().execute());

        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().execute());
    }
}
