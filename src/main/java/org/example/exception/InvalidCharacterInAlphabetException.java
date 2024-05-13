package org.example.exception;

/**
 * The InvalidCharacterInAlphabetException is thrown when an invalid character is found in the alphabet string.
 */
public class InvalidCharacterInAlphabetException extends RuntimeException {

    /**
     * Constructs an InvalidCharacterInAlphabetException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public InvalidCharacterInAlphabetException(String message) {
        super("Alphabet contains invalid character " + message + ". It must be only an alphabetic letter.");
    }
}
