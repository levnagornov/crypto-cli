package org.example.menu;

import org.example.alphabet.*;
import org.example.cipher.CaesarCipher;
import org.example.util.Console;
import org.example.util.FileProcessor;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MenuController {
    public static ResultableMenuItem<String> languageSelectionMenu = new ResultableMenuItem<>("Choose language", MenuController::chooseAlphabetLanguage);
    public static ResultableMenuItem<File> getFileForEncryptionMenu = new ResultableMenuItem<>("Provide the path to the file to be encrypted:", Console::getUserFile);
    public static ResultableMenuItem<Integer> getIntKeyForEncryptionMenu = new ResultableMenuItem<>("Provide key for encryption:", Console::readIntUserInput);
    public static ResultableMenuItem<File> getFileForDecryptionMenu = new ResultableMenuItem<>("Provide the path to the encrypted file to be decrypted:", Console::getUserFile);
    public static ResultableMenuItem<Integer> getIntKeyForDecryptionMenu = new ResultableMenuItem<>("Provide key for decryption:", Console::readIntUserInput);

    private static String chooseAlphabetLanguage() {
        int choice;
        String language;

        while (true) {
            System.out.println("Choose the language of the encrypted file:");

            for (int i = 0; i < Language.values().length; i++) {
                System.out.println(i + 1 + ". " + Language.values()[i]);
            }

            choice = Console.readIntUserInput();

            switch (Language.values()[choice - 1]) {
                case ENGLISH -> language = "ENGLISH";
                case RUSSIAN -> language = "RUSSIAN";
                case GREEK -> language = "GREEK";
                case JAPANESE -> language = "JAPANESE";
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
            }

            return language;
        }
    }

    public static void encryptCaesarByKey() {
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
        File resultFile = FileProcessor.createResultFile(encryptedFile.getParent(), "encryption_result");

        // Encrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, key);
        caesarCipher.processAndWriteToFile(encryptedFile, resultFile, true);
    }

    public static void encryptCaesarByRandomKey() {
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
        File resultFile = FileProcessor.createResultFile(encryptedFile.getParent(), "encryption_with_a_random_result");

        // Encrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, key);
        caesarCipher.processAndWriteToFile(encryptedFile, resultFile, true);
    }

    public static void decryptCaesarByKey() {
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
        File resultFile = FileProcessor.createResultFile(encryptedFile.getParent(), "encryption_result");

        // Decrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, key);
        caesarCipher.processAndWriteToFile(encryptedFile, resultFile, false);
    }

    public static void decryptCaesarByBrutForce() {
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
        File resultFile = FileProcessor.createResultFile(encryptedFile.getParent(), "decryption_with_brut_force_result");

        // Decrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet);
        caesarCipher.brutForceAndWriteToFile(encryptedFile, resultFile);
    }

    public static void decryptWithFrequencyAnalysis() {
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
        File resultFile = FileProcessor.createResultFile(encryptedFile.getParent(), "decryption_with_frequency_analysis_result");

        // Decrypt
        CaesarCipher caesarCipher = new CaesarCipher(alphabet);
        caesarCipher.frequencyAnalysisAndWriteToFile(encryptedFile, resultFile);
    }
}
