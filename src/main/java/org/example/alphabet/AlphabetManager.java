package org.example.alphabet;

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
        return new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    /**
     * Returns a Russian alphabet dictionary.
     *
     * @return The Russian alphabet dictionary.
     */
    private static AlphabetDictionary getRussianAlphabet() {
        return new Alphabet("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
    }

    /**
     * Returns a Greek alphabet dictionary.
     *
     * @return The Greek alphabet dictionary.
     */
    private static AlphabetDictionary getGreekAlphabet() {
        return new Alphabet("ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩ");
    }

    /**
     * Returns a Japanese alphabet dictionary.
     *
     * @return The Japanese alphabet dictionary.
     */
    private static AlphabetDictionary getJapaneseAlphabet() {
        return new Alphabet("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん");
    }
}
