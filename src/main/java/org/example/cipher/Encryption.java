package org.example.cipher;

/**
 * The Encryption interface represents a contract for encryption operations.
 */
public interface Encryption {

    /**
     * Encrypts the given text.
     *
     * @param text The text to encrypt.
     * @return The encrypted text.
     */
    String encrypt(String text);
}
