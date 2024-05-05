package org.example.menu;

/**
 * The ResultableMenuItem class represents a menu item that executes a command and returns a result.
 *
 * @param <T> The type of the result returned by the command.
 */
public class ResultableMenuItem<T> extends MenuItem {
    private T result;

    /**
     * Constructs a ResultableMenuItem with the specified title.
     *
     * @param title   The title of the menu item.
     */
    public ResultableMenuItem(String title) {
        super(title);
    }

    /**
     * Executes the actions associated with the menu item and stores the result.
     */
    @Override
    public void execute() {
        System.out.println("*** " + getTitle() + " ***");
    }

    /**
     * Returns the result of some menu execution.
     *
     * @return The result of some menu execution.
     */
    public T getResult(){
        return result;
    }

    /**
     * Sets the result of some menu execution.
     */
    protected void setResult(T result) {
        this.result = result;
    }
}
