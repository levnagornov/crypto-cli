package org.example.alphabet;

import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;
import java.util.HashMap;
import java.util.Map;

/**
 * The Alphabet class represents an alphabet dictionary.
 */
public class Alphabet implements AlphabetDictionary {
    private final String alphabet;
    private final Map<Character, Integer> alphabetWithPositions;

    /**
     * Constructs an Alphabet object with the specified alphabet string.
     *
     * @param alphabet The string representing the alphabet.
     * @throws NotUniqueLettersInAlphabetException If the alphabet contains duplicate letters.
     * @throws InvalidCharacterInAlphabetException If the alphabet contains non-alphabetic characters.
     * @throws EmptyAlphabetException              If the alphabet string is empty.
     */
    public Alphabet(String alphabet) {
        if (alphabet.isEmpty()) {
            throw new EmptyAlphabetException();
        }

        this.alphabet = alphabet;
        this.alphabetWithPositions = createAlphabetWithPositions();
    }

    /**
     * Creates a map of letters and their positions in the alphabet.
     *
     * @return A map of letters and their positions.
     * @throws InvalidCharacterInAlphabetException If the alphabet contains non-alphabetic characters.
     * @throws NotUniqueLettersInAlphabetException If the alphabet contains duplicate letters.
     */
    private Map<Character, Integer> createAlphabetWithPositions() {
        Map<Character, Integer> alphabetWithPositions = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++) {
            char currentLetter = alphabet.charAt(i);

            if (!Character.isAlphabetic(currentLetter)) {
                throw new InvalidCharacterInAlphabetException(Character.toString(currentLetter));
            }

            if (alphabetWithPositions.get(currentLetter) != null) {
                throw new NotUniqueLettersInAlphabetException(Character.toString(currentLetter));
            }

            // Adding both lower and upper case, {a:0, A:0, b:1, B:1, c:2, C:2, ...}
            alphabetWithPositions.put(Character.toLowerCase(currentLetter), i);
            alphabetWithPositions.put(Character.toUpperCase(currentLetter), i);
        }

        return alphabetWithPositions;
    }

    /**
     * Returns the length of the alphabet.
     *
     * @return The length of the alphabet.
     */
    public int getLength() {
        return alphabet.length();
    }

    /**
     * Returns the position of the given letter in the alphabet.
     *
     * @param letter The letter whose position is to be found.
     * @return The position of the given letter in the alphabet, or null if the letter is not present.
     */
    public Integer getLetterPosition(char letter) {
        return alphabetWithPositions.get(letter);
    }

    /**
     * Returns the letter of the alphabet by its position.
     *
     * @param position The position of the letter in the alphabet.
     * @return The letter of the alphabet at the specified position.
     * @throws IndexOutOfBoundsException If the position is negative or exceeds the length of the alphabet.
     */
    public char getLetterByPosition(int position) {
        if (position < 0 || position > getLength()) {
            throw new IndexOutOfBoundsException("Position must be a positive integer or zero");
        }

        return alphabet.charAt(position);
    }
}
