package controller.Commands;

import model.interfaces.ICommand;

public class RedoCommand implements ICommand {
    @Override
    public void execute() {
        CommandHistory.redo();
    }
}
