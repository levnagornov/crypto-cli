package org.example.util;

import java.io.File;
import java.util.Scanner;

public class Console {
    public static Scanner scanner = new Scanner(System.in);

    public static File getUserFile() {
        String input = readStrUserInput();
        File userFile = new File(input);

        while (!userFile.exists()) {
            System.out.println("This file doesn't exists, please check the path and try again.");
            input = readStrUserInput();
            userFile = new File(input);
        }

        return userFile;
    }

    public static int readIntUserInput() {
        while (!scanner.hasNextInt() && scanner.hasNext()) {
            scanner.nextLine();
            System.out.println("Please enter integer and try again.");
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static String readStrUserInput() {
        return scanner.nextLine();
    }
}
