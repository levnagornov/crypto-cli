package org.example.exception;

/**
 * The EmptyAlphabetException is thrown when an attempt is made to create an alphabet with an empty string.
 */
public class EmptyAlphabetException extends Exception {

    /**
     * Constructs an EmptyAlphabetException with the default detail message.
     */
    public EmptyAlphabetException() {
        super("Alphabet can't be empty.");
    }
}
