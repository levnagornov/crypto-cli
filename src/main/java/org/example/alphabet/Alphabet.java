package org.example.alphabet;

import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;
import java.util.HashMap;
import java.util.Map;

public class Alphabet implements AlphabetDictionary {

    private final String alphabet;
    private final Map<Character, Integer> alphabetWithPositions;

    public Alphabet(String alphabet) throws NotUniqueLettersInAlphabetException, InvalidCharacterInAlphabetException, EmptyAlphabetException {
        if (alphabet.isEmpty()) {
            throw new EmptyAlphabetException();
        }

        this.alphabet = alphabet;
        this.alphabetWithPositions = createAlphabetWithPositions();
    }

    /**
     * It creates a map of a letter and alphabet letter position.
     * Example: if alphabet = "ABC", then alphabet with positions will be {A:0, B:1, C:2}
     *
     * @return A map of a letter and alphabet letter position.
     * @throws InvalidCharacterInAlphabetException if alphabet contains non-alphabetic character.
     * @throws NotUniqueLettersInAlphabetException if alphabet contains duplicates of one letter.
     */
    private Map<Character, Integer> createAlphabetWithPositions() throws InvalidCharacterInAlphabetException, NotUniqueLettersInAlphabetException {
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
     * @return the length of the alphabet.
     */
    public int getLength() {
        return alphabet.length();
    }


    /**
     * Returns a position of the given letter in the alphabet, or null if the letter is not there.
     *
     * @param letter the letter whose position is to be found.
     * @return the position of the given letter in the alphabet, or null if the letter is not there.
     */
    public Integer getLetterPosition(char letter) {
        return alphabetWithPositions.get(letter);
    }


    /**
     * Returns a letter of the alphabet by its position in it.
     *
     * @param position the search letter position.
     * @return the letter of the alphabet by its position in it
     * @throws IndexOutOfBoundsException if the position argument is negative, or it exceeds the alphabet length.
     */
    public char getLetterByPosition(int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > getLength()) {
            throw new IndexOutOfBoundsException("Position must be a positive integer or zero");
        }

        return alphabet.charAt(position);
    }
}
