package org.example.cipher;

/**
 * The Decryption interface represents a contract for decryption operations.
 */
public interface Decryption {

    /**
     * Decrypts the given text.
     *
     * @param text The text to decrypt.
     * @return The decrypted text.
     */
    String decrypt(String text);
}
