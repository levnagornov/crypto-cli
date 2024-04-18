package org.example.menu;

import org.example.util.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The MainMenuItem class represents the main menu of the application.
 */
public class MainMenuItem extends MenuItem {
    private static boolean isActive = true;
    private static List<MenuItem> menuItems;

    /**
     * Constructs a MainMenuItem with the specified title.
     *
     * @param title The title of the main menu item.
     */
    public MainMenuItem(String title) {
        super(title);
    }

    /**
     * Executes the main menu.
     */
    public void execute() {
        initMenu();
        while (isActive) {
            printMenu();
            int choice = Console.readIntUserInput();
            selectMenuItem(choice);
        }
    }

    private void initMenu() {
        menuItems = new ArrayList<>(Arrays.asList(
                new NestedMenuItem("Encryption", Arrays.asList(
                        new CommandMenuItem("Encrypt using the Caesar cipher and a specific key", MenuController::encryptCaesarByKey),
                        new CommandMenuItem("Encrypt using the Caesar cipher and a random key", MenuController::encryptCaesarByRandomKey)
                )),
                new NestedMenuItem("Decryption", Arrays.asList(
                        new CommandMenuItem("Decrypt the Caesar cipher using a specific key", MenuController::decryptCaesarByKey),
                        new CommandMenuItem("Decrypt the Caesar cipher using brut force", MenuController::decryptCaesarByBrutForce),
                        new CommandMenuItem("Decrypt using frequency analysis", MenuController::decryptCaesarByBrutForce)
                ))
        ));
    }

    private void printMenu() {
        System.out.println();
        System.out.println("*** " + getTitle() + " ***");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getTitle());
        }
        System.out.println("0. Exit");
    }

    private void selectMenuItem(int choice) {
        if (choice > 0 && choice <= menuItems.size()) {
            menuItems.get(choice - 1).execute();
        } else if (choice == 0) {
            isActive = false;
            System.out.println("Execution has been completed. Bye-bye!");
        } else {
            System.out.println("Incorrect option. Please try again.");
        }
    }
}
