package org.example;

import org.example.menu.MainMenuItem;
import org.example.util.Console;

public class Main {
    public static void main(String[] args) {
        MainMenuItem mainMenu = new MainMenuItem("Main menu");
        mainMenu.execute();
        Console.scanner.close();
    }
}
