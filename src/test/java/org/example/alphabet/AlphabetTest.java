package org.example.alphabet;

import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetTest {

    @Test
    void getLength() {
        var englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var alphabetWith26Letters = new Alphabet(englishAlphabet);
        assertEquals(englishAlphabet.length(), alphabetWith26Letters.getLength());
    }

    @Test
    void getLetterPositionWithUpperCaseLetter() {
        var englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var alphabetWith26Letters = new Alphabet(englishAlphabet);
        var letter = 'Z';
        assertEquals(englishAlphabet.indexOf(letter), alphabetWith26Letters.getLetterPosition(letter));
    }

    @Test
    void getLetterPositionWithLowerCaseLetter() {
        var englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var alphabetWith26Letters = new Alphabet(englishAlphabet);
        var letter = 'j';
        assertEquals(englishAlphabet.indexOf(Character.toUpperCase(letter)), alphabetWith26Letters.getLetterPosition(letter));
    }

    @Test
    void getLetterByPositionWithPositiveNumber() {
        var englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var alphabetWith26Letters = new Alphabet(englishAlphabet);
        var positivePosition = 10;
        assertEquals(englishAlphabet.charAt(positivePosition), alphabetWith26Letters.getLetterByPosition(positivePosition));
    }

    @Test
    void getLetterByPositionWithNegativeNumber() {
        var englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var alphabetWith26Letters = new Alphabet(englishAlphabet);
        var negativePosition = -10;
        assertThrows(IndexOutOfBoundsException.class, () -> alphabetWith26Letters.getLetterByPosition(negativePosition));
    }

    @Test
    void getLetterByPositionWithPositionThatExceedsTheAlphabetLength() {
        var englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var alphabetWith26Letters = new Alphabet(englishAlphabet);
        var wrongPosition = 30;
        assertThrows(IndexOutOfBoundsException.class, () -> alphabetWith26Letters.getLetterByPosition(wrongPosition));
    }

    @Test
    void constructorThrowsEmptyAlphabetException() {
        var emptyAlphabet = "";
        assertThrows(EmptyAlphabetException.class, () -> new Alphabet(emptyAlphabet));
    }

    @Test
    void constructorThrowsInvalidCharacterInAlphabetExceptionOnNumberInAlphabet() {
        var invalidAlphabet = "ABC1";
        assertThrows(InvalidCharacterInAlphabetException.class, () -> new Alphabet(invalidAlphabet));
    }

    @Test
    void constructorThrowsInvalidCharacterInAlphabetExceptionOnPunctuationSignInAlphabet() {
        var invalidAlphabet = "ABC.";
        assertThrows(InvalidCharacterInAlphabetException.class, () -> new Alphabet(invalidAlphabet));
    }

    @Test
    void constructorThrowsInvalidCharacterInAlphabetExceptionOnSpaceInAlphabet() {
        var invalidAlphabet = "ABC ";
        assertThrows(InvalidCharacterInAlphabetException.class, () -> new Alphabet(invalidAlphabet));
    }

    @Test
    void constructorThrowsNotUniqueLettersInAlphabetException() {
        var invalidAlphabet = "ABBA";
        assertThrows(NotUniqueLettersInAlphabetException.class, () -> new Alphabet(invalidAlphabet));
    }
}