// Usiel Figueroa
// March 17, 2025
// CSD420-A311 Advanced Java Programming
// M1: Programming Assignment 

/**
References 
(n.d.). JavaFX Tutorial. Tutorialspoint.com. Retrieved March 17, 2025, from https://www.tutorialspoint.com/javafx/index.htm 

(n.d.). Java Tutorial. W3schools. Retrieved March 17, 2025, from https://www.w3schools.com/java/ 

AssignmentCards Folder
 */




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;
import java.util.stream.IntStream;

public class Main extends Application {
    private static final String CARD_PATH = "cards/";
    private static final int CARD_COUNT = 52;
    private static final int DISPLAY_COUNT = 4;
    private final Random random = new Random();
    private final ImageView[] cardViews = new ImageView[DISPLAY_COUNT];

    @Override
    public void start(Stage primaryStage) {
        // Initialize ImageView array
        for (int i = 0; i < DISPLAY_COUNT; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setPreserveRatio(true);
        }

        // Button to refresh images
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> updateCards());

        // Layout setup
        HBox cardBox = new HBox(10, cardViews);
        VBox root = new VBox(10, cardBox, refreshButton);

        // Load initial random cards
        updateCards();

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateCards() {
        // Generate unique random numbers for cards
        int[] selectedCards = random.ints(1, CARD_COUNT + 1)
                                    .distinct()
                                    .limit(DISPLAY_COUNT)
                                    .toArray();

        IntStream.range(0, DISPLAY_COUNT).forEach(i -> {
            File file = new File(CARD_PATH + selectedCards[i] + ".png");
            if (file.exists()) {
                cardViews[i].setImage(new Image(file.toURI().toString()));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
