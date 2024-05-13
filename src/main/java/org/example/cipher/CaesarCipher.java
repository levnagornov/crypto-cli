package org.example.cipher;

import org.example.alphabet.AlphabetDictionary;
import org.example.exception.LetterIsNotInAlphabetException;

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
    public String encrypt(String text) {
        return process(text, key);
    }

    /**
     * Decrypts the given text using the Caesar cipher algorithm.
     *
     * @param text The text to decrypt.
     * @return The decrypted text.
     */
    public String decrypt(String text) {
        return process(text, -key);
    }

    /**
     * Performs encryption or decryption on the given text based on the provided shift value.
     *
     * @param text  The text to process.
     * @param shift The shift value for encryption/decryption.
     * @return The processed text.
     */
    private String process(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char letter : text.toCharArray()) {
            if (Character.isAlphabetic(letter)) {
                char shiftedLetter = shiftLetter(letter, shift);
                result.append(shiftedLetter);
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }

    /**
     * Shifts the given letter according to the provided shift value.
     *
     * @param letter The letter to shift.
     * @param shift  The shift value for encryption/decryption.
     * @return The shifted letter.
     * @throws LetterIsNotInAlphabetException If the letter is not found in the alphabet.
     */
    private char shiftLetter(char letter, int shift) {
        int alphabetLength = alphabet.getLength();
        int currentPosition = alphabet.getLetterPosition(letter);
        if (currentPosition == -1) {
            throw new LetterIsNotInAlphabetException(Character.toString(letter));
        }
        int shiftedPosition = (currentPosition + shift + alphabetLength) % alphabetLength;
        return alphabet.getLetterByPosition(shiftedPosition);
    }

    /**
     * Decrypts the given text using the Caesar cipher algorithm with brute-force approach,
     * trying all possible keys from 1 to alphabet length - 1.
     * For each key, it decrypts the text and appends the result along with the key information.
     *
     * @param text The text to decrypt.
     * @return The decrypted text for each possible key.
     */
    public String decryptWithBruteForce(String text) {
        StringBuilder decryptedText = new StringBuilder();
        for (int key = 1; key < alphabet.getLength(); key++) {
            this.key = key;
            decryptedText.append("Decrypting with a key ")
                    .append(key)
                    .append(" :")
                    .append(System.lineSeparator())
                    .append(decrypt(text))
                    .append(System.lineSeparator());
        }
        return decryptedText.toString();
    }

    /**
     * Decrypts the given text using the Caesar cipher algorithm with frequency analysis.
     *
     * @param text The text to decrypt.
     * @return The decrypted text for each possible key.
     */
    public String decryptWithFrequencyAnalysis(String text) {
        System.out.println("Received text is " + text.length() + " length");
        System.out.println("Not implemented yet");
        return text;
    }
}
