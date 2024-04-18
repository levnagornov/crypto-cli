package org.example.menu;

import java.util.function.Supplier;

/**
 * The ResultableMenuItem class represents a menu item that executes a command and returns a result.
 *
 * @param <T> The type of the result returned by the command.
 */
public class ResultableMenuItem<T> extends MenuItem {
    private final Supplier<T> command;
    private T result;

    /**
     * Constructs a ResultableMenuItem with the specified title and command.
     *
     * @param title   The title of the menu item.
     * @param command The command to be executed when the menu item is selected.
     */
    public ResultableMenuItem(String title, Supplier<T> command) {
        super(title);
        this.command = command;
    }

    /**
     * Executes the command associated with the menu item and stores the result.
     */
    @Override
    public void execute() {
        System.out.println("*** " + getTitle() + " ***");
        result = command.get();
    }

    /**
     * Returns the result of the command execution.
     *
     * @return The result of the command execution.
     */
    public T getResult(){
        return result;
    }
}
