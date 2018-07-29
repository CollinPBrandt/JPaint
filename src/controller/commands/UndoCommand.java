package controller.commands;

import model.interfaces.ICommand;

public class UndoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.undo();
    }
}
