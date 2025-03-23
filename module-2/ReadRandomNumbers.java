import java.io.*;

/**
 * Usiel Figueroa
 * March 23, 2025
 * CSD420-A311 Advanced Java Programming
 * M2: Programming Assignment - Read Program
 * 
 * This program reads and displays the contents of the file.
 */

/**
References:
 * https://www.geeksforgeeks.org/generating-random-numbers-in-java    
 * https://www.geeksforgeeks.org/how-to-read-file-in-java/
 * (n.d.). Java Tutorial. W3schools. Retrieved March 23, 2025, from https://www.w3schools.com/java/ 
 */

public class ReadRandomNumbers {
    public static void main(String[] args) {
        String filename = "UsielFigueroa_datafile.dat";
        readNumbersFromFile(filename);
    }

    /**
     * Reads and displays the content of the file.
     */
    public static void readNumbersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\nContents of " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
