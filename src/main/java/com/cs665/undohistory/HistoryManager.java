package com.cs665.undohistory;

import com.cs665.Framework.commands.Command;

import java.util.Stack;

/**
 * Created by mburke on 5/31/17.
 */
public class HistoryManager {
    private Stack<Command> history = new Stack<>();

    public Stack<Command> getHistory() {
        return history;
    }

    public void execute(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    public void undo() {
        if (history.size() > 0) {
            Command cmd = history.pop();
            cmd.undo();
        }
    }

    public void clear() {
        history = new Stack<>();
    }
}
