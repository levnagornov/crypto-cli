package org.example.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * The Console class provides utility methods for interacting with the console,
 * including reading user input from the keyboard and retrieving files specified by the user.
 * It implements AutoCloseable interface to ensure proper resource management.
 */
public class Console implements UserInputProvider, AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads an integer input from the console.
     * Continuously prompts the user until an integer is entered.
     *
     * @return Integer entered by the user.
     */
    public Path getUserFile() {
        String input = readStrUserInput();
        Path userFile = Path.of(input);

        while (!Files.exists(userFile)) {
            System.out.println("This file doesn't exists, please check the path and try again.");
            input = readStrUserInput();
            userFile = Path.of(input);
        }

        return userFile;
    }

    /**
     * Reads an integer input from the console.
     * Continuously prompts the user until an integer is entered.
     *
     * @return Integer entered by the user.
     */
    public int readIntUserInput() {
        while (!scanner.hasNextInt() && scanner.hasNext()) {
            scanner.nextLine();
            System.out.println("Please enter integer and try again.");
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    /**
     * Reads a string input from the console.
     *
     * @return String entered by the user.
     */
    public String readStrUserInput() {
        return scanner.nextLine();
    }

    /**
     * Closes the scanner, releasing any system resources associated with it.
     */
    @Override
    public void close() {
        scanner.close();
    }
}
