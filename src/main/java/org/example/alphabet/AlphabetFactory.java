package org.example.alphabet;

/**
 * The AlphabetFactory class provides methods for obtaining alphabet dictionaries for different languages.
 */
public class AlphabetFactory {

    /**
     * Returns an alphabet dictionary for the specified language.
     *
     * @param language The language for which the alphabet dictionary is requested.
     * @return The alphabet dictionary for the specified language.
     */
    public static AlphabetDictionary getAlphabet(Language language) {
        return switch (language) {
            case ENGLISH -> new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            case RUSSIAN -> new Alphabet("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
            case GREEK -> new Alphabet("ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩ");
            case JAPANESE -> new Alphabet("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん");
        };
    }
}
