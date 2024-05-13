package org.example.exception;

/**
 * The LetterIsNotInAlphabetException is thrown when a letter is not found in the alphabet dictionary.
 */
public class LetterIsNotInAlphabetException extends RuntimeException {

    /**
     * Constructs a LetterIsNotInAlphabetException with the specified detail message.
     *
     * @param message The detail message explaining which letter is not found in the alphabet.
     */
    public LetterIsNotInAlphabetException(String message) {
        super("Letter <" + message + "> is not in the alphabet.");
    }
}
