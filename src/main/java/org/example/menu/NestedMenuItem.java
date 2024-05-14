package org.example.menu;

import org.example.inputprovider.UserInputProvider;
import java.util.List;

/**
 * The NestedMenuItem class represents a menu item that contains a submenu of other menu items.
 */
public class NestedMenuItem extends MenuItem {
    private boolean isActive;
    private final List<MenuItem> submenuItems;
    private final UserInputProvider inputProvider;

    /**
     * Constructs a NestedMenuItem with the specified title and submenu items.
     *
     * @param title        The title of the menu item.
     * @param submenuItems The list of submenu items.
     */
    public NestedMenuItem(String title, List<MenuItem> submenuItems, UserInputProvider inputProvider) {
        super(title);
        this.submenuItems = submenuItems;
        this.inputProvider = inputProvider;
    }

    /**
     * Executes the submenu associated with the menu item.
     */
    @Override
    public void execute() {
        isActive = true;
        while (isActive) {
            printMenu();
            int choice = inputProvider.readIntUserInput();
            selectMenuItem(choice);
        }
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
