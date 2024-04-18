package org.example.menu;

import java.util.List;

/**
 * The NestedSequentialMenuItem class represents a menu item that executes its submenu items sequentially.
 */
public class NestedSequentialMenuItem extends MenuItem {
    private final List<MenuItem> submenuItems;

    /**
     * Constructs a NestedSequentialMenuItem with the specified title and submenu items.
     *
     * @param title        The title of the menu item.
     * @param submenuItems The list of submenu items.
     */
    public NestedSequentialMenuItem(String title, List<MenuItem> submenuItems) {
        super(title);
        this.submenuItems = submenuItems;
    }

    /**
     * Executes the submenu items sequentially.
     */
    @Override
    public void execute() {
        System.out.println("*** " + getTitle() + " ***");
        for (MenuItem menuItem : submenuItems) {
            menuItem.execute();
        }
    }
}
