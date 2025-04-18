// Usiel Figueroa
// April 17, 2025
// CSD420-A311 Advanced Java Programming
// M8: Programming Assignment
// Purpose: This program uses three threads to ouput 10,000 random letters, numbers, and special characters each into separate text areas.

/*
References:
(2025, April 11). Multithreading in Java. Geeksforgeeks. Retrieved April 17, 2025, from https://www.geeksforgeeks.org/multithreading-in-java/
(n.d.). Java - Multithreading. Tutorialspoint. Retrieved April 17, 2025, from https://www.tutorialspoint.com/java/java_multithreading.htm
*/

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

// The Main class extends the Application class and overrides the start method to set up the GUI and run the threads.
public class UsielThreeThreads extends Application {

    private static final int OUTPUT_COUNT = 10000;

    private final TextArea lettersArea = new TextArea();
    private final TextArea numbersArea = new TextArea();
    private final TextArea symbolsArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setupTextArea(lettersArea);
        setupTextArea(numbersArea);
        setupTextArea(symbolsArea);
        // Create labels for each text area to indicate what type of output it contains.
        Label lettersLabel = new Label("Letters Output:");
        Label numbersLabel = new Label("Numbers Output:");
        Label symbolsLabel = new Label("Symbols Output:");

        VBox root = new VBox(
                lettersLabel, lettersArea,
                numbersLabel, numbersArea,
                symbolsLabel, symbolsArea
        );

        VBox.setVgrow(lettersArea, Priority.ALWAYS);
        VBox.setVgrow(numbersArea, Priority.ALWAYS);
        VBox.setVgrow(symbolsArea, Priority.ALWAYS);

        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        runThreads();
    }

    private void setupTextArea(TextArea area) {
        area.setEditable(false);
        area.setWrapText(true);
        area.setStyle("-fx-font-family: 'monospace'; -fx-font-size: 14px;");
    }
    // This method creates three threads and starts them. Each thread outputs a specified number of random characters (letters, numbers, or symbols) to a text area.
    private void runThreads() {
        Thread letters = new Thread(() -> outputRandomLetters());
        Thread numbers = new Thread(() -> outputRandomNumbers());
        Thread symbols = new Thread(() -> outputRandomSymbols());

        letters.start();
        numbers.start();
        symbols.start();
    }
    // This method generates a specified number of random letters and updates the text area with the output.
    private void outputRandomLetters() {
        Random random = new Random();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < OUTPUT_COUNT; i++) {
            char c = (char) ('a' + random.nextInt(26));
            output.append(c);
        }
        output.append("\n[Letters thread finished. Characters printed: ").append(OUTPUT_COUNT).append("]\n");

        Platform.runLater(() -> lettersArea.setText(output.toString()));
    }
    // This method generates a specified number of random numbers and updates the text area with the output.
    private void outputRandomNumbers() {
        Random random = new Random();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < OUTPUT_COUNT; i++) {
            char c = (char) ('0' + random.nextInt(10));
            output.append(c);
        }
        output.append("\n[Numbers thread finished. Characters printed: ").append(OUTPUT_COUNT).append("]\n");

        Platform.runLater(() -> numbersArea.setText(output.toString()));
    }
    // This method generates a specified number of random symbols and updates the text area with the output.
    private void outputRandomSymbols() {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        Random random = new Random();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < OUTPUT_COUNT; i++) {
            char c = symbols[random.nextInt(symbols.length)];
            output.append(c);
        }
        output.append("\n[Symbols thread finished. Characters printed: ").append(OUTPUT_COUNT).append("]\n");

        Platform.runLater(() -> symbolsArea.setText(output.toString()));
    }
}
