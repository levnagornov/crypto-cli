package org.example.alphabet;

import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;

/**
 * The AlphabetManager class provides methods for obtaining alphabet dictionaries for different languages.
 */
public class AlphabetManager {

    /**
     * Returns an alphabet dictionary for the specified language.
     *
     * @param language The language for which the alphabet dictionary is requested.
     * @return The alphabet dictionary for the specified language.
     */
    public static AlphabetDictionary getAlphabet(String language) {
        return switch (Language.valueOf(language)) {
            case ENGLISH -> getEnglishAlphabet();
            case RUSSIAN -> getRussianAlphabet();
            case GREEK -> getGreekAlphabet();
            case JAPANESE -> getJapaneseAlphabet();
        };
    }

    /**
     * Returns an English alphabet dictionary.
     *
     * @return The English alphabet dictionary.
     */
    private static AlphabetDictionary getEnglishAlphabet() {
        try {
            return new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        } catch (NotUniqueLettersInAlphabetException | EmptyAlphabetException | InvalidCharacterInAlphabetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a Russian alphabet dictionary.
     *
     * @return The Russian alphabet dictionary.
     */
    private static AlphabetDictionary getRussianAlphabet() {
        try {
            return new Alphabet("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
        } catch (NotUniqueLettersInAlphabetException | EmptyAlphabetException | InvalidCharacterInAlphabetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a Greek alphabet dictionary.
     *
     * @return The Greek alphabet dictionary.
     */
    private static AlphabetDictionary getGreekAlphabet() {
        try {
            return new Alphabet("ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩ");
        } catch (NotUniqueLettersInAlphabetException | EmptyAlphabetException | InvalidCharacterInAlphabetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a Japanese alphabet dictionary.
     *
     * @return The Japanese alphabet dictionary.
     */
    private static AlphabetDictionary getJapaneseAlphabet() {
        try {
            return new Alphabet("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん");
        } catch (NotUniqueLettersInAlphabetException | EmptyAlphabetException | InvalidCharacterInAlphabetException e) {
            throw new RuntimeException(e);
        }
    }
}
