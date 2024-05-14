package org.example.menu;

import org.example.controller.MenuController;
import org.example.inputprovider.UserInputProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The MainMenuItem class represents the main menu of the application.
 */
public class MainMenuItem extends MenuItem {
    private boolean isActive = true;
    private List<MenuItem> menuItems;
    private final UserInputProvider inputProvider;
    private final MenuController menuController;

    /**
     * Constructs a MainMenuItem with the specified title.
     *
     * @param title The title of the main menu item.
     */
    public MainMenuItem(String title, UserInputProvider inputProvider, MenuController menuController) {
        super(title);
        this.inputProvider = inputProvider;
        this.menuController = menuController;
    }

    /**
     * Executes the main menu.
     */
    public void execute() {
        initMenu();
        while (isActive) {
            printMenu();
            int choice = inputProvider.readIntUserInput();
            selectMenuItem(choice);
        }
    }

    private void initMenu() {
        String encryptionMenuHeader = "Encryption";
        String decryptionMenuHeader = "Decryption";

        List<MenuItem> encryptionMenuOptions = Arrays.asList(
                new CommandMenuItem("Encrypt using the Caesar cipher and a specific key", menuController::encryptCaesarByKey),
                new CommandMenuItem("Encrypt using the Caesar cipher and a random key", menuController::encryptCaesarByRandomKey));

        List<MenuItem> decryptionMenuOptions = Arrays.asList(
                new CommandMenuItem("Decrypt the Caesar cipher using a specific key", menuController::decryptCaesarByKey),
                new CommandMenuItem("Decrypt the Caesar cipher using brut force", menuController::decryptCaesarByBrutForce),
                new CommandMenuItem("Decrypt using frequency analysis", menuController::decryptWithFrequencyAnalysis));

        menuItems = new ArrayList<>(Arrays.asList(
                new NestedMenuItem(encryptionMenuHeader, encryptionMenuOptions, inputProvider),
                new NestedMenuItem(decryptionMenuHeader, decryptionMenuOptions, inputProvider)));
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
