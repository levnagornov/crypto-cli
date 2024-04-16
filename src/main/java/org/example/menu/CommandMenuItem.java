package org.example.menu;

public class CommandMenuItem extends MenuItem {
    private final Runnable command;

    public CommandMenuItem(String title, Runnable command) {
        super(title);
        this.command = command;
    }

    @Override
    public void execute() {
        command.run();
    }
}
