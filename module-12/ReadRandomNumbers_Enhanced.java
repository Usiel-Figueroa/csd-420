

/**
 * Usiel Figueroa
 * May 16, 2025
 * CSD420-A311 Advanced Java Programming
 * Original M2: Programming Assignment 
  * M:12 Redo Assignment:Enhanced Program - Write and Read Random Numbers
 * 
 * This program reads and displays the contents of the file with enhanced error handling based on the Professor feedback.
 */

import java.io.*;


public class ReadRandomNumbers_Enhanced {
    public static void main(String[] args) {
        String filename = "UsielFigueroa_datafile.dat";
        readNumbersFromFile(filename);
    }

    /**
     * Reads and displays the content of the file with enhanced error handling.
     */
    public static void readNumbersFromFile(String filename) {
        File file = new File(filename);

        if (!file.exists() || !file.isFile()) {
            System.err.println("Error: The file does not exist.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\nContents of " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Check the file path.");
        } catch (SecurityException e) {
            System.err.println("Error: Access denied. Check file permissions.");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
