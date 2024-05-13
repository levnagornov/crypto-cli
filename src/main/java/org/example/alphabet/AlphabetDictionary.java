package org.example.alphabet;

/**
 * The AlphabetDictionary interface represents a contract for interacting with alphabet dictionaries.
 */
public interface AlphabetDictionary {

    /**
     * Returns the length of the alphabet.
     *
     * @return The length of the alphabet.
     */
    int getLength();

    /**
     * Returns the position of the specified letter in the alphabet.
     *
     * @param letter The letter whose position is to be determined.
     * @return The position of the letter in the alphabet, or null if the letter is not found.
     */
    Integer getLetterPosition(char letter);

    /**
     * Returns the letter at the specified position in the alphabet.
     *
     * @param position The position of the letter.
     * @return The letter at the specified position.
     */
    char getLetterByPosition(int position);
}
