package model;

import model.interfaces.ICommand;
import view.gui.PaintCanvas;

public class SelectShapeCommand implements ICommand {

    private ShapeDimensions dimensions;
    private PaintCanvas canvas;

    public SelectShapeCommand(ShapeDimensions dimensions, PaintCanvas canvas) {
        this.dimensions = dimensions;
        this.canvas = canvas;
    }

    @Override
    public void execute() {

    }
}
