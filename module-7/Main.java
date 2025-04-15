/**
 * Usiel Figueroa
 * April 14, 2025
 * CSD420-A311 Advanced Java Programming
 * Module 7: JavaFX Circle Style Demo (Final Version)
 *
 * Purpose: Displays four circles using style classes and IDs arranged to match the assignment layout.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Circle inside black rectangle
        Circle boxedCircle = new Circle(40);
        boxedCircle.getStyleClass().add("plaincircle");

        StackPane borderedPane = new StackPane(boxedCircle);
        borderedPane.getStyleClass().add("border");
        borderedPane.setPrefSize(40, 400); 

        // Remaining three circles: white, red, green
        Circle whiteCircle = new Circle(40);
        whiteCircle.getStyleClass().add("plaincircle");

        Circle redCircle = new Circle(40);
        redCircle.setId("redcircle");

        Circle greenCircle = new Circle(40);
        greenCircle.setId("greencircle");

        // Layout everything horizontally
        HBox root = new HBox(6, borderedPane, whiteCircle, redCircle, greenCircle);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root);
        scene.getStylesheets().add("CircleAttributes.css");

        primaryStage.setTitle("Usiel Figueroa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
