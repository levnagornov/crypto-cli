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
    void encryptWithKeyZero() {
        caesarCipher = new CaesarCipher(alphabet, 0);
        assertEquals("ABC", caesarCipher.encrypt("ABC"));
    }

    @Test
    void decryptWithKeyZero() {
        caesarCipher = new CaesarCipher(alphabet, 0);
        assertEquals("ABC", caesarCipher.decrypt("ABC"));
    }

    @Test
    void encryptWithSmallPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 2);
        assertEquals("CDE", caesarCipher.encrypt("ABC"));
        caesarCipher = new CaesarCipher(alphabet, 2);
        assertEquals("ZAB", caesarCipher.encrypt("XYZ"));
    }

    @Test
    void decryptWithSmallPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 2);
        assertEquals("ABC", caesarCipher.decrypt("CDE"));
        caesarCipher = new CaesarCipher(alphabet, 2);
        assertEquals("YZA", caesarCipher.decrypt("ABC"));
    }

    @Test
    void encryptWithSmallNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -2);
        assertEquals("ABC", caesarCipher.encrypt("CDE"));
        caesarCipher = new CaesarCipher(alphabet, -2);
        assertEquals("YZA", caesarCipher.encrypt("ABC"));
    }

    @Test
    void decryptWithSmallNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -2);
        assertEquals("CDE", caesarCipher.decrypt("ABC"));
    }

    @Test
    void encryptWithBigPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 26);
        assertEquals("ABC", caesarCipher.encrypt("ABC"));
    }

    @Test
    void decryptWithBigPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 26);
        assertEquals("ABC", caesarCipher.decrypt("ABC"));
    }

    @Test
    void encryptWithBigNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -26);
        assertEquals("ABC", caesarCipher.encrypt("ABC"));
    }

    @Test
    void decryptWithBigNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -26);
        assertEquals("ABC", caesarCipher.decrypt("ABC"));
    }

    @Test
    void encryptWithGiantPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 79);
        assertEquals("BCD", caesarCipher.encrypt("ABC"));
    }

    @Test
    void decryptWithGiantPositiveKey() {
        caesarCipher = new CaesarCipher(alphabet, 79);
        assertEquals("ABC", caesarCipher.decrypt("BCD"));
    }

    @Test
    void encryptWithGiantNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -79);
        assertEquals("ABC", caesarCipher.encrypt("BCD"));
    }

    @Test
    void decryptWithGiantNegativeKey() {
        caesarCipher = new CaesarCipher(alphabet, -79);
        assertEquals("BCD", caesarCipher.decrypt("ABC"));
    }

    @Test
    void encryptIsCaseSensitive() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertEquals("Efg", caesarCipher.encrypt("Def"));
    }

    @Test
    void decryptIsCaseSensitive() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertEquals("Def", caesarCipher.decrypt("Efg"));
    }

    @Test
    void encryptSkipsNonLetters() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertEquals("?EFG .! OP1", caesarCipher.encrypt("?DEF .! NO1"));
    }

    @Test
    void decryptSkipsNonLetters() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertEquals("?DEF .! NO1", caesarCipher.decrypt("?EFG .! OP1"));
    }

    @Test
    void encryptThrowsExceptionWhenLetterIsNotInAlphabet() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertThrows(RuntimeException.class, () -> caesarCipher.encrypt("XYZЭЮЯ"));
    }

    @Test
    void decryptThrowsExceptionWhenLetterIsNotInAlphabet() {
        caesarCipher = new CaesarCipher(alphabet, 1);
        assertThrows(RuntimeException.class, () -> caesarCipher.decrypt("XYZЭЮЯ"));
    }
}