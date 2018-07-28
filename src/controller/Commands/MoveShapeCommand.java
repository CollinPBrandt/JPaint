package controller.Commands;

import view.Mouse.MouseDragDimensions;
import model.interfaces.ICommand;
import view.gui.PaintCanvas;

public class MoveShapeCommand implements ICommand {

    private MouseDragDimensions dimensions;
    private PaintCanvas canvas;

    public MoveShapeCommand(MouseDragDimensions dimensions, PaintCanvas canvas) {
        this.dimensions = dimensions;
        this.canvas = canvas;
    }


    @Override
    public void execute() {

    }
}
