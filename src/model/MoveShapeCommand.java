package model;

import model.interfaces.ICommand;
import view.gui.PaintCanvas;

public class MoveShapeCommand implements ICommand {

    private Pair start;
    private Pair end;
    private PaintCanvas canvas;

    public MoveShapeCommand(Pair start, Pair end, PaintCanvas canvas) {
        this.start = start;
        this.end = end;
        this.canvas = canvas;
    }


    @Override
    public void execute() {

    }
}
