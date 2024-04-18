package org.example.menu;

/**
 * The CommandMenuItem class represents a menu item that executes a specific command when selected.
 */
public class CommandMenuItem extends MenuItem {
    private final Runnable command;

    /**
     * Constructs a CommandMenuItem with the specified title and command.
     *
     * @param title   The title of the menu item.
     * @param command The command to be executed when the menu item is selected.
     */
    public CommandMenuItem(String title, Runnable command) {
        super(title);
        this.command = command;
    }

    /**
     * Executes the command associated with the menu item.
     */
    @Override
    public void execute() {
        command.run();
    }
}
