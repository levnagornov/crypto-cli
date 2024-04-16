package org.example.cipher;

import org.example.alphabet.Alphabet;
import org.example.alphabet.AlphabetDictionary;
import org.example.exception.EmptyAlphabetException;
import org.example.exception.InvalidCharacterInAlphabetException;
import org.example.exception.NotUniqueLettersInAlphabetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {

    private CaesarCipher caesarCipher;
    private AlphabetDictionary alphabet;

    @BeforeEach
    void setUp() throws NotUniqueLettersInAlphabetException, EmptyAlphabetException, InvalidCharacterInAlphabetException {
        alphabet = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    @Test
    void encodeWithKeyZero() {
        caesarCipher = new CaesarCipher(alphabet, 0);
        assertEquals("ABC", caesarCipher.encrypt("ABC"));
    }

    @Test
    void encodeWithSmallPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 2);
        assertEquals("CDE", caesarCipher.encrypt("ABC"));
    }

    @Test
    void encodeWithSmallNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -2);
        assertEquals("ABC", caesarCipher.encrypt("CDE"));
    }

    @Test
    void encodeWithBigPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 26);
        assertEquals("ABC", caesarCipher.encrypt("ABC"));
    }

    @Test
    void encodeWithBigNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -26);
        assertEquals("ABC", caesarCipher.encrypt("ABC"));
    }

    @Test
    void encodeWithGiantPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 78);
        assertEquals("ABC", caesarCipher.encrypt("ABC"));
    }

    @Test
    void encodeWithGiantNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -78);
        assertEquals("ABC", caesarCipher.encrypt("ABC"));
    }

    @Test
    void encodeIsCaseSensitive() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertEquals("Efg", caesarCipher.encrypt("Def"));
    }

    @Test
    void encodeSkipsNonLetters() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertEquals("?EFG .! OP1", caesarCipher.encrypt("?DEF .! NO1"));
    }

    @Test
    void encodeThrowsExceptionWhenLetterIsNotInAlphabet() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertThrows(RuntimeException.class, () -> caesarCipher.encrypt("XYZЭЮЯ"));
    }
}