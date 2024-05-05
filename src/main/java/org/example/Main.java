package org.example;

import org.example.menu.MenuController;
import org.example.util.Console;

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
