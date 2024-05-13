package org.example.util;

/**
 * The Processor interface represents a template method for data processing.
 * Implementations of this interface should provide specific implementations for reading, calculating, and writing data.
 */
public interface Processor {

    /**
     * Template method for processing data.
     * It includes sequential steps of reading, calculating, and writing.
     */
    default void process() {
        read();
        calculate();
        write();
    }

    /**
     * Method for reading data.
     * Implementation should provide logic to read data.
     */
    void read();

    /**
     * Method for calculating data.
     * Implementation should provide logic to calculate data.
     */
    void calculate();

    /**
     * Method for writing data.
     * Implementation should provide logic to write data.
     */
    void write();
}
