package controller.commands;

import controller.interfaces.ICommand;

public class RedoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.redo();
    }
}
