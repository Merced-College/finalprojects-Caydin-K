// UndoManager.java

import java.util.Stack;

public class UndoManager {
    private Stack<Task> undoStack;

    public UndoManager() {
        undoStack = new Stack<>();
    }

    public void push(Task task) {
        undoStack.push(task);
    }

    public Task undo() {
        if (undoStack.isEmpty()) return null;
        return undoStack.pop();
    }

    public boolean hasUndo() {
        return !undoStack.isEmpty();
    }
}
