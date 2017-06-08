package com.cs665.Framework.commands;

/**
 * Created by mburke on 5/31/17.
 */
public abstract class Command {
    public abstract void execute();

    public abstract void undo();
}
