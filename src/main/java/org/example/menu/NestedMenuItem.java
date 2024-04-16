package org.example.menu;

import org.example.util.Console;
import java.util.List;

public class NestedMenuItem extends MenuItem {
    private boolean isActive;
    private final List<MenuItem> submenuItems;

    public NestedMenuItem(String title, List<MenuItem> submenuItems) {
        super(title);
        this.submenuItems = submenuItems;
    }

    @Override
    public void execute() {
        isActive = true;
        while (isActive) {
            printMenu();
            int choice = Console.readIntUserInput();
            selectMenuItem(choice);
        }
    }

    public List<MenuItem> getSubmenuItems() {
        return submenuItems;
    }

    private void printMenu() {
        System.out.println();
        System.out.println("*** " + getTitle() + " ***");
        for (int i = 0; i < submenuItems.size(); i++) {
            System.out.println((i + 1) + ". " + submenuItems.get(i).getTitle());
        }
        System.out.println("0. Back");
    }

    private void selectMenuItem(int choice) {
        if (choice == 0) {
            isActive = false;
        } else if (choice > 0 && choice <= submenuItems.size()) {
            isActive = false;
            submenuItems.get(choice - 1).execute();
        } else {
            System.out.println("Incorrect option. Please try again.");
        }
    }
}
