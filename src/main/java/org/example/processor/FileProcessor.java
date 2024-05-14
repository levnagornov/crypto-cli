package org.example.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

/**
 * The FileProcessor class implements the Processor interface for processing data from files.
 * It reads data from an input file, applies a provided function for calculation, and writes the result to an output file.
 */
public class FileProcessor implements Processor {
    private String data;
    private String result;
    private final Path inputFile;
    private final Path outputFile;
    private final Function<String, String> function;

    /**
     * Constructs a new FileProcessor instance with the specified input and output files and calculation function.
     *
     * @param inputFile  The path to the input file.
     * @param outputFile The path to the output file.
     * @param function   The function to apply for calculation.
     */
    public FileProcessor(Path inputFile, Path outputFile, Function<String, String> function) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.function = function;
    }

    /**
     * Reads data from the input file.
     *
     * @throws RuntimeException if an error occurs while reading the input file.
     */
    @Override
    public void read() {
        try {
            data = new String(Files.readAllBytes(inputFile));
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file", e);
        }
    }

    /**
     * Applies the calculation function to the data.
     */
    @Override
    public void calculate() {
        result = function.apply(data);
    }

    /**
     * Writes the result to the output file.
     *
     * @throws RuntimeException if an error occurs while writing the output file.
     */
    @Override
    public void write() {
        try {
            Files.writeString(outputFile, result);
        } catch (IOException e) {
            throw new RuntimeException("Error writing output file", e);
        }
    }
}
