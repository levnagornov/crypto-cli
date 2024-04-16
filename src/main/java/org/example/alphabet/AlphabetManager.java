package org.example.alphabet;

import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;

public class AlphabetManager {
    public static AlphabetDictionary getAlphabet(String language) {
        return switch (Language.valueOf(language)) {
            case ENGLISH -> getEnglishAlphabet();
            case RUSSIAN -> getRussianAlphabet();
            case GREEK -> getGreekAlphabet();
            case JAPANESE -> getJapaneseAlphabet();
        };
    }

    private static AlphabetDictionary getEnglishAlphabet() {
        try {
            return new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        } catch (NotUniqueLettersInAlphabetException | EmptyAlphabetException | InvalidCharacterInAlphabetException e) {
            throw new RuntimeException(e);
        }
    }

    private static AlphabetDictionary getRussianAlphabet() {
        try {
            return new Alphabet("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
        } catch (NotUniqueLettersInAlphabetException | EmptyAlphabetException | InvalidCharacterInAlphabetException e) {
            throw new RuntimeException(e);
        }
    }

    private static AlphabetDictionary getGreekAlphabet() {
        try {
            return new Alphabet("ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩ");
        } catch (NotUniqueLettersInAlphabetException | EmptyAlphabetException | InvalidCharacterInAlphabetException e) {
            throw new RuntimeException(e);
        }
    }

    private static AlphabetDictionary getJapaneseAlphabet() {
        try {
            return new Alphabet("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん");
        } catch (NotUniqueLettersInAlphabetException | EmptyAlphabetException | InvalidCharacterInAlphabetException e) {
            throw new RuntimeException(e);
        }
    }
}
