package org.example.util;

import java.io.File;

/**
 * The UserInputProvider interface provides methods for interacting with user input.
 */
public interface UserInputProvider {
    /**
     * Reads an integer input from the user.
     *
     * @return Integer entered by the user.
     */
    int readIntUserInput();

    /**
     * Reads a string input from the user.
     *
     * @return String entered by the user.
     */
    String readStrUserInput();

    /**
     * Retrieves a file specified by the user.
     *
     * @return File specified by the user.
     */
    File getUserFile();
}

