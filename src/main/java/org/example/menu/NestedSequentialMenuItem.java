package org.example.menu;

import java.util.List;

public class NestedSequentialMenuItem extends MenuItem {
    private final List<MenuItem> submenuItems;

    public NestedSequentialMenuItem(String title, List<MenuItem> submenuItems) {
        super(title);
        this.submenuItems = submenuItems;
    }

    @Override
    public void execute() {
        System.out.println("*** " + getTitle() + " ***");
        for (MenuItem menuItem : submenuItems) {
            menuItem.execute();
        }
    }
}
