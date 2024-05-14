package org.example;

import org.example.controller.MenuController;
import org.example.inputprovider.Console;

/**
 * The Main class serves as the entry point of the program.
 */
public class Main {
    public static void main(String[] args) {
        try (Console console = new Console()) {
            new MenuController(console).run();
        }
    }
}
