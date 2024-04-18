package org.example;

import org.example.menu.MainMenuItem;
import org.example.util.Console;

/**
 * The Main class serves as the entry point of the program.
 */
public class Main {
    public static void main(String[] args) {
        MainMenuItem mainMenu = new MainMenuItem("Main menu");
        mainMenu.execute();
        Console.scanner.close();
    }
}
