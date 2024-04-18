package org.example.menu;

/**
 * The MenuItem class represents an abstract menu item.
 */
public abstract class MenuItem {
    private final String title;

    /**
     * Constructs a MenuItem with the specified title.
     *
     * @param title The title of the menu item.
     */
    public MenuItem(String title) {
        this.title = title;
    }

    /**
     * Returns the title of the menu item.
     *
     * @return The title of the menu item.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Executes the action associated with the menu item.
     */
    public abstract void execute();
}
