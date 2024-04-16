package org.example.cipher;

import org.example.alphabet.AlphabetDictionary;
import org.example.exception.LetterIsNotInAlphabetException;
import java.io.*;

public class CaesarCipher implements Encryption, Decryption {
    private final AlphabetDictionary alphabet;
    private int key;

    public CaesarCipher(AlphabetDictionary alphabet, int key) {
        this.alphabet = alphabet;
        this.key = key;
    }

    public CaesarCipher(AlphabetDictionary alphabet) {
        this.alphabet = alphabet;
        this.key = 0;
    }

    @Override
    public String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (char letter : text.toCharArray()) {
            try {
                encryptedText.append(shiftLetter(letter));
            } catch (LetterIsNotInAlphabetException e) {
                throw new RuntimeException(e);
            }
        }
        return encryptedText.toString();
    }

    @Override
    public String decrypt(String text) {
        key = alphabet.getLength() - key;
        return encrypt(text);
    }

    public void processAndWriteToFile(File inputFile, File outputFile, boolean encrypt) {
        int bufferSize = 8 * 1024; // 8Kb

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile), bufferSize);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            char[] buffer = new char[bufferSize];

            // Process in chunks
            while (reader.read(buffer, 0, bufferSize) != -1) {
                String text = new String(buffer);
                writer.write(encrypt ? encrypt(text) : decrypt(text));
            }
        } catch (IOException e) {
            System.out.println("ERROR while processing the file: " + e.getMessage());
        }
    }

    public void brutForceAndWriteToFile(File inputFile, File outputFile) {
        for (int key = 1; key < alphabet.getLength(); key++) {
            this.key = key;
            int bufferSize = 8 * 1024; // 8Kb

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile), bufferSize);
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))
            ) {
                writer.write("Decrypting with a key=" + key + ":\n");
                char[] buffer = new char[bufferSize];

                // Process in chunks
                while (reader.read(buffer, 0, bufferSize) != -1) {
                    String text = new String(buffer);
                    writer.write(decrypt(text));
                }
            } catch (IOException e) {
                System.out.println("ERROR while processing the file: " + e.getMessage());
            }
        }
    }

    private char shiftLetter(char letter) throws LetterIsNotInAlphabetException {
        int alphabetLength = alphabet.getLength();
        if (key == 0 || key % alphabetLength == 0) {
            return letter;
        }

        // Skip non-alphabetic symbols like . , ! etc.
        if (!Character.isAlphabetic(letter)) {
            return letter;
        }

        Integer currentIndex = alphabet.getLetterPosition(letter);
        if (currentIndex == null) {
            throw new LetterIsNotInAlphabetException(Character.toString(letter));
        }

        int shiftedIndex = (currentIndex + key) % alphabetLength;
        char shiftedLetter = alphabet.getLetterByPosition(shiftedIndex);

        return Character.isUpperCase(letter)
                ? Character.toUpperCase(shiftedLetter)
                : Character.toLowerCase(shiftedLetter);
    }

    public void frequencyAnalysisAndWriteToFile(File encryptedFile, File resultFile) {
        System.out.println("Not implemented yet");
    }
}
