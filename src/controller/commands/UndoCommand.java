package controller.commands;

import controller.interfaces.ICommand;

public class UndoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.undo();
    }
}
