import java.io.*;
import java.util.Random;

/**
 * Usiel Figueroa
 * March 23, 2025
 * CSD420-A311 Advanced Java Programming
 * M2: Programming Assignment - Write Program
 * 
 * This program generates an array of random integers and an array of random doubles,
 * then writes them to a file. If the file exists, the data is appended.
 */

/**
References:
 * https://www.geeksforgeeks.org/generating-random-numbers-in-java    
 * https://www.geeksforgeeks.org/how-to-read-file-in-java/
 * (n.d.). Java Tutorial. W3schools. Retrieved March 23, 2025, from https://www.w3schools.com/java/ 
 */

public class WriteRandomNumbers {
    public static void main(String[] args) {
        String filename = "UsielFigueroa_datafile.dat";
        writeRandomNumbersToFile(filename);
    }

    /**
     * Generates random integers and doubles, then writes them to a file.
     * If the file exists, it appends data; otherwise, it creates a new file.
     */
    public static void writeRandomNumbersToFile(String filename) {
        Random random = new Random();
        try (FileWriter fileWriter = new FileWriter(filename, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            printWriter.println("Random Integers:");
            for (int i = 0; i < 5; i++) {
                printWriter.print(random.nextInt(100) + " ");
            }
            printWriter.println();

            printWriter.println("Random Doubles:");
            for (int i = 0; i < 5; i++) {
                printWriter.print(random.nextDouble() * 100 + " ");
            }
            printWriter.println("\n----------------------");

            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
