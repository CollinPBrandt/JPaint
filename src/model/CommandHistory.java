package model;

import java.util.Stack;

class CommandHistory {
    /*private static final Stack<Command> undoStack = new Stack<Command>();
    private static final Stack<Command> redoStack = new Stack<Command>();

    public static void add(Command cmd) {
        undoStack.push(cmd);
        redoStack.clear();
    }

    public static boolean undo() {
        boolean result = !undoStack.empty();
        if (result) {
            Command c = undoStack.pop();
            redoStack.push(c);
            c.undo();
        }
        return result;
    }

    public static boolean redo() {
        boolean result = !redoStack.empty();
        if (result) {
            Command c = redoStack.pop();
            undoStack.push(c);
            c.redo();
        }
        return result;
    }

    // For testing
    Command topUndoCommand() {
        if (undoStack.empty())
            return null;
        else
            return undoStack.peek();
    }
    // For testing
    Command topRedoCommand() {
        if (redoStack.empty())
            return null;
        else
            return redoStack.peek();
    }*/
}
