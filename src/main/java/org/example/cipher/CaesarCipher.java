package org.example.cipher;

import org.example.alphabet.AlphabetDictionary;
import org.example.exception.LetterIsNotInAlphabetException;
import java.io.*;

/**
 * The CaesarCipher class represents the Caesar cipher, which is used for encrypting and decrypting text.
 */
public class CaesarCipher implements Encryption, Decryption {
    private final AlphabetDictionary alphabet;
    private int key;

    /**
     * Constructor for the CaesarCipher class.
     *
     * @param alphabet The alphabet dictionary used for encryption and decryption.
     * @param key      The encryption/decryption key.
     */
    public CaesarCipher(AlphabetDictionary alphabet, int key) {
        this.alphabet = alphabet;
        this.key = key % alphabet.getLength();
    }

    /**
     * Constructor for the CaesarCipher class without a key (uses default value - 0).
     *
     * @param alphabet The alphabet dictionary used for encryption and decryption.
     */
    public CaesarCipher(AlphabetDictionary alphabet) {
        this.alphabet = alphabet;
        this.key = 0;
    }

    /**
     * Encrypts the given text using the Caesar cipher algorithm.
     *
     * @param text The text to encrypt.
     * @return The encrypted text.
     */
    @Override
    public String encrypt(String text) {
        key = key > 0 ? key : alphabet.getLength() + key ;
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

    /**
     * Decrypts the given text using the Caesar cipher algorithm.
     *
     * @param text The text to decrypt.
     * @return The decrypted text.
     */
    @Override
    public String decrypt(String text) {
        key = key > 0 ? alphabet.getLength() - key : key * -1;
        return encrypt(text);
    }

    /**
     * Processes the input file and then writes the result to the output file.
     * Processing is either encryption or decryption of the file.
     *
     * @param inputFile  The input file to process.
     * @param outputFile The output file to write the result.
     * @param encrypt    True if encryption is needed, false for decryption.
     */
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

    /**
     * Performs brute-force decryption of the input file and writes the result to the output file.
     *
     * @param inputFile  The input file to decrypt.
     * @param outputFile The output file to write the decrypted content.
     */
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

    /**
     * Shifts the given letter according to the encryption/decryption key.
     *
     * @param letter The letter to shift.
     * @return The shifted letter.
     * @throws LetterIsNotInAlphabetException If the letter is not found in the alphabet dictionary.
     */
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

    /**
     * Performs frequency analysis on the encrypted file and writes the result to a separate file.
     *
     * @param encryptedFile The file containing the encrypted text.
     * @param resultFile    The file to write the frequency analysis result.
     */
    public void frequencyAnalysisAndWriteToFile(File encryptedFile, File resultFile) {
        System.out.println("Not implemented yet");
    }
}
