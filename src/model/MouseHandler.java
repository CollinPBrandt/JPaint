package model;

import model.interfaces.ICommand;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;
import view.gui.PaintCanvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private Pair start;
    private Pair end;
    private ICommand command;
    private ApplicationState appState;
    private PaintCanvas canvas;
    private ShapeList shapeList;

    public MouseHandler(PaintCanvas canvas, ApplicationState appState){
        this.canvas = canvas;
        this.appState = appState;
        shapeList = new ShapeList(canvas);
    }

    private void setCommand() {
        switch (appState.getActiveStartAndEndPointMode()) {
            case DRAW:
                this.command = new CreateShapeCommand(start, end, appState, shapeList);
                break;
            case SELECT:
                this.command = new SelectShapeCommand(start, end, canvas);
                break;
            case MOVE:
                this.command = new MoveShapeCommand(start, end, canvas);
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        start = new Pair(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        end = new Pair(e.getX(), e.getY());
        setCommand();
        command.execute();
    }
}
