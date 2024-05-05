package org.example.menu;

import java.util.function.Supplier;

/**
 * The ResultableCommandMenuItem class represents a menu item that executes a command and stores a result of the command.
 *
 * @param <T> The type of the result returned by the command.
 */
public class ResultableCommandMenuItem<T> extends ResultableMenuItem<T> {
    private final Supplier<T> command;

    /**
     * Constructs a ResultableCommandMenuItem with the specified title and command.
     *
     * @param title   The title of the menu item.
     * @param command The command to be executed when the menu item is selected.
     */
    public ResultableCommandMenuItem(String title, Supplier<T> command) {
        super(title);
        this.command = command;
    }

    /**
     * Executes the command associated with the menu item and stores the result.
     */
    @Override
    public void execute() {
        System.out.println("*** " + getTitle() + " ***");
        setResult(command.get());
    }
}
