package org.example.menu;

import org.example.alphabet.Language;
import java.util.function.Supplier;

/**
 * A menu item for selecting the language of the encrypted file.
 * It allows users to choose from available languages and sets the selected language as the result.
 */
public class AlphabetLanguageSelectionMenuItem extends ResultableMenuItem<String> {
    private final Supplier<Integer> supplier;

    /**
     * Constructs a new AlphabetLanguageSelectionMenuItem with the given title and supplier for user input.
     *
     * @param title    The title of the menu item.
     * @param supplier The supplier for user input.
     */
    public AlphabetLanguageSelectionMenuItem(String title, Supplier<Integer> supplier) {
        super(title);
        this.supplier = supplier;
    }

    /**
     * Executes the menu item, allowing users to choose a language from the available options.
     * It sets the selected language as the result.
     */
    public void execute() {
        Language[] languages = Language.values();
        int numberOfLanguages = languages.length;
        int choice;


        System.out.println("Choose the language of the encrypted file:");

        for (int i = 0; i < Language.values().length; i++) {
            System.out.println(i + 1 + ". " + Language.values()[i]);
        }

        while (true) {
            choice = supplier.get() - 1;
            if (choice >= numberOfLanguages || choice < 0) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            break;
        }

        String selectedLanguage = languages[choice].toString();
        setResult(selectedLanguage);
    }
}
