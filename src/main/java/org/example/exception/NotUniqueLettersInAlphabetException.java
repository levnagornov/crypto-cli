package org.example.exception;

/**
 * The NotUniqueLettersInAlphabetException is thrown when non-unique letters are found in the alphabet string.
 */
public class NotUniqueLettersInAlphabetException extends Exception {

    /**
     * Constructs a NotUniqueLettersInAlphabetException with the specified detail message.
     *
     * @param message The detail message explaining which non-unique letter is found in the alphabet.
     */
    public NotUniqueLettersInAlphabetException(String message) {
        super("The letter is not unique in the alphabet " + message + ". Alphabet must contain only unique letters");
    }
}
