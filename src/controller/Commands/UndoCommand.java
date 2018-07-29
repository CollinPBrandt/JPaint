package controller.Commands;

import model.interfaces.ICommand;

public class UndoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.undo();
    }
}
