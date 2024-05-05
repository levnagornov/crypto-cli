package org.example.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for creating files.
 */
public class FileCreator {

    /**
     * Creates a file with the specified name and path.
     *
     * @param path The path where the file should be created.
     * @param name The name of the file.
     * @return The created file.
     */
    public static File createResultFile(String path, String name) {
        File resultFile = new File(path, name);

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

    /**
     * Creates a unique file name based on the current date and time.
     *
     * @param name The name of the file without date and time.
     * @return A unique file name with date and time.
     */
    public static String generateUniqueFileName(String name, String extension) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss"); // e.g. 20240406_16-57-47
        String currentDateTime = dateFormat.format(new Date());
        return name + "_" + currentDateTime + "." + extension;
    }
}
