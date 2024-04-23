package org.example.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileCreator {
    public static File createResultFile(String path, String name) {
        File resultFile = new File(path, createTextFileNameWithDateTime(name));

        try {
            if (resultFile.createNewFile()) {
                System.out.println("The result file has been created: " + resultFile.getAbsolutePath());
            } else {
                throw new IOException("Couldn't create the result file, the name already exists");
            }
        } catch (IOException e) {
            System.err.println("ERROR: Error occurred while creating the result file " + resultFile.getAbsolutePath() + " " + e.getMessage());
        }

        return resultFile;
    }

    private static String createTextFileNameWithDateTime(String name) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss"); // e.g. 20240406_16-57-47
        String currentDateTime = dateFormat.format(new Date());
        return name + "_" + currentDateTime + ".txt";
    }
}
