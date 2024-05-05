package org.example.menu;

import org.example.alphabet.*;
import org.example.cipher.CaesarCipher;
import org.example.util.FileCreator;
import org.example.util.UserInputProvider;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * The MenuController class contains methods for handling menu actions.
 */
public class MenuController {
    private final UserInputProvider inputProvider;
    private final ResultableMenuItem<String> languageSelectionMenu;
    private final ResultableMenuItem<File> getFileForEncryptionMenu;
    private final ResultableMenuItem<Integer> getIntKeyForEncryptionMenu;
    private final ResultableMenuItem<File> getFileForDecryptionMenu;
    private final ResultableMenuItem<Integer> getIntKeyForDecryptionMenu;

    public MenuController(UserInputProvider inputProvider) {
        this.inputProvider = inputProvider;
        languageSelectionMenu = new AlphabetLanguageSelectionMenuItem("Choose language", inputProvider::readIntUserInput);
        getFileForEncryptionMenu = new ResultableCommandMenuItem<>("Provide the path to the file to be encrypted:", inputProvider::getUserFile);
        getIntKeyForEncryptionMenu = new ResultableCommandMenuItem<>("Provide key for encryption:", inputProvider::readIntUserInput);
        getFileForDecryptionMenu = new ResultableCommandMenuItem<>("Provide the path to the encrypted file to be decrypted:", inputProvider::getUserFile);
        getIntKeyForDecryptionMenu = new ResultableCommandMenuItem<>("Provide key for decryption:", inputProvider::readIntUserInput);
    }

    /**
     * Runs the menu controller, allowing users to navigate through various encryption and decryption options.
     * It initializes the main menu and starts the menu execution loop.
     */
    public void run() {
        MainMenuItem mainMenu = new MainMenuItem("Main menu", inputProvider, this);
        mainMenu.execute();
    }

    /**
     * Encrypts a file using the Caesar cipher with a specific key.
     */
    public void encryptCaesarByKey() {
        NestedSequentialMenuItem menus = new NestedSequentialMenuItem(
                "Encrypt using the Caesar cipher and a specific key",
                new ArrayList<>(Arrays.asList(
                    languageSelectionMenu,
                    getFileForEncryptionMenu,
                    getIntKeyForEncryptionMenu
                ))
        );
        menus.execute();

        // Choose language
        String language = languageSelectionMenu.getResult();

        // Create according alphabet
        AlphabetDictionary alphabet = AlphabetManager.getAlphabet(language);

        // Get a file for encryption
        File encryptedFile = getFileForEncryptionMenu.getResult();

        // Get a key
        int key = getIntKeyForEncryptionMenu.getResult();

        // Create result file
        File resultFile = FileCreator.createResultFile(
                encryptedFile.getParent(),
                FileCreator.generateUniqueFileName("encryption_result", "txt"));

        // Encrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, key);
        caesarCipher.processAndWriteToFile(encryptedFile, resultFile, true);
    }

    /**
     * Encrypts a file using the Caesar cipher with a random key.
     */
    public void encryptCaesarByRandomKey() {
        NestedSequentialMenuItem menus = new NestedSequentialMenuItem(
                "Encrypt using the Caesar cipher and a random key",
                new ArrayList<>(Arrays.asList(
                        languageSelectionMenu,
                        getFileForEncryptionMenu
                ))
        );
        menus.execute();

        // Choose language
        String language = languageSelectionMenu.getResult();

        // Create according alphabet
        AlphabetDictionary alphabet = AlphabetManager.getAlphabet(language);

        // Get a file for encryption
        File encryptedFile = getFileForEncryptionMenu.getResult();

        // Get a key
        int key = new Random().nextInt(1, alphabet.getLength());
        System.out.println("Random key will be used: " + key);

        // Create result file
        File resultFile = FileCreator.createResultFile(
                encryptedFile.getParent(),
                FileCreator.generateUniqueFileName("encryption_with_a_random_key_result", "txt"));

        // Encrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, key);
        caesarCipher.processAndWriteToFile(encryptedFile, resultFile, true);
    }

    /**
     * Decrypts a file encrypted with the Caesar cipher using a specific key.
     */
    public void decryptCaesarByKey() {
        NestedSequentialMenuItem menus = new NestedSequentialMenuItem(
                "Decrypt the Caesar cipher using a specific key",
                new ArrayList<>(Arrays.asList(
                    languageSelectionMenu,
                    getFileForDecryptionMenu,
                    getIntKeyForDecryptionMenu
                ))
        );
        menus.execute();

        // Choose language
        String language = languageSelectionMenu.getResult();

        // Create according alphabet
        AlphabetDictionary alphabet = AlphabetManager.getAlphabet(language);

        // Get an encrypted file
        File encryptedFile = getFileForDecryptionMenu.getResult();

        // Get a key
        int key = getIntKeyForDecryptionMenu.getResult();

        // Create result file
        File resultFile = FileCreator.createResultFile(
                encryptedFile.getParent(),
                FileCreator.generateUniqueFileName("decryption_result", "txt"));

        // Decrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, key);
        caesarCipher.processAndWriteToFile(encryptedFile, resultFile, false);
    }

    /**
     * Decrypts a file encrypted with the Caesar cipher using brute force.
     */
    public void decryptCaesarByBrutForce() {
        NestedSequentialMenuItem menus = new NestedSequentialMenuItem(
                "Decrypt the Caesar cipher using brut force",
                new ArrayList<>(Arrays.asList(
                    languageSelectionMenu,
                    getFileForDecryptionMenu
                ))
        );
        menus.execute();

        // Choose language
        String language = languageSelectionMenu.getResult();

        // Create according alphabet
        AlphabetDictionary alphabet = AlphabetManager.getAlphabet(language);

        // Get an encrypted file
        File encryptedFile = getFileForDecryptionMenu.getResult();

        // Create result file
        File resultFile = FileCreator.createResultFile(
                encryptedFile.getParent(),
                 FileCreator.generateUniqueFileName("decryption_with_brut_force_result", "txt"));

        // Decrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet);
        caesarCipher.brutForceAndWriteToFile(encryptedFile, resultFile);
    }

    /**
     * Decrypts a file encrypted with the Caesar cipher using frequency analysis.
     */
    public void decryptWithFrequencyAnalysis() {
        NestedSequentialMenuItem menus = new NestedSequentialMenuItem(
                "Decrypt the Caesar cipher using brut force",
                new ArrayList<>(Arrays.asList(
                        languageSelectionMenu,
                        getFileForDecryptionMenu
                ))
        );
        menus.execute();

        // Choose language
        String language = languageSelectionMenu.getResult();

        // Create according alphabet
        AlphabetDictionary alphabet = AlphabetManager.getAlphabet(language);

        // Get an encrypted file
        File encryptedFile = getFileForDecryptionMenu.getResult();

        // Create result file
        File resultFile = FileCreator.createResultFile(
                encryptedFile.getParent(),
                FileCreator.generateUniqueFileName("decryption_with_frequency_analysis_result", "txt"));

        // Decrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet);
        caesarCipher.frequencyAnalysisAndWriteToFile(encryptedFile, resultFile);
    }
}
