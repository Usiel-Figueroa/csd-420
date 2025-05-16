

/**
 * Usiel Figueroa
 * May 16, 2025
 * CSD420-A311 Advanced Java Programming
 * Original M2: Programming Assignment 
 * M:12 Redo Assignment:Enhanced Program - Write and Read Random Numbers
 * 
 * This program generates an array of random integers and an array of random doubles,
 * then writes them to a file. If the file exists, the data is appended.
 * It also reads the file and displays the contents with enhanced error handling based on the Professor feedback.
 */
import java.io.*;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class WriteRandomNumbers_Enhanced {
    public static void main(String[] args) {
        String filename = "UsielFigueroa_datafile.dat";
        writeRandomNumbersToFile(filename);
    }

    /**
     * Generates random integers and doubles, then writes them to a file.
     * If the file exists, it appends data; otherwise, it creates a new file.
     * Enhanced error handling based on the Professor feedback.
     */
    public static void writeRandomNumbersToFile(String filename) {
        Random random = new Random();
        try (FileWriter fileWriter = new FileWriter(filename, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            printWriter.println("\nTimestamp: " + now.format(formatter));

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
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Check the file path.");
        } catch (SecurityException e) {
            System.err.println("Error: Access denied. Check file permissions.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
