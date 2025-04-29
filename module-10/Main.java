/*
Usiel Figueroa
April 28, 2025
CSD420-A311 Advanced Java Programming - M10: Programming Assignment

Purpose: JavaFX program to view and update fan information from a MySQL database using TableView for better UI.
*/

/** 
Reference 

[Design and Development - Video Production]. (2021, February 4). JDBC Introduction [Video]. Bellevue University. https://bellevue.mediaspace.kaltura.com/media/JDBC+Introduction/1_lr4h7olz 

(n.d.). Java Tutorial. W3schools. Retrieved March 23, 2025, from https://www.w3schools.com/java/ 

Liang, Y. D. (n.d.). Introduction to Java Programming and Data Structures, Comprehensive Version. Retrieved from https://platform.virdocs.com/read/2229015/303/#/4/2[P700101715900000000000000000A8ED]/20[P700101715900000000000000000A910]/14[P700101715900000000000000000A921]/2[P700101715900000000000000000A922],/1:0,/1:0  

(n.d.). List of X-Men members. Wikipedia. Retrieved April 28, 2025, from https://en.wikipedia.org/wiki/List_of_X-Men_members 

(n.d.). List of Avengers members. Wikipedia. Retrieved April 28, 2025, from https://en.wikipedia.org/wiki/List_of_Avengers_members 

*/ 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {

    // Declare the UI components as class-level variables
    private TextField fanIdField, firstNameField, lastNameField, favoriteTeamField;
    private TextArea instructionsArea;
    private Button displayButton, updateButton;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create a label for the title of the application
        Label instructionLabel = new Label("Welcome to Usiel's Fan Information App!");
        instructionLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Create a TextArea to provide instructions to the user
        instructionsArea = new TextArea();
        instructionsArea.setEditable(false); // Make it non-editable
        instructionsArea.setWrapText(true);  // Enable text wrapping for long instructions
        instructionsArea.setText(
            "Display and Update Fan Information:\n\n" +
            "1. Please enter a fan ID (between 1 and 12) in the 'Fan ID' field.\n" +
            "2. Click 'Display' to see the details of the fan (First Name, Last Name, Favorite Team).\n" +
            "3. Modify the information as needed.\n" +
            "4. Click 'Update' to save changes to the database.\n\n" +
            "Notice:  Once updated, enter the fan ID (between 1 and 12) to see the modifications.."
        );

        // Create text fields for user input: Fan ID, First Name, Last Name, and Favorite Team
        fanIdField = new TextField();
        fanIdField.setPromptText("Enter Fan ID (1-12)");  // Set placeholder text

        firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        favoriteTeamField = new TextField();
        favoriteTeamField.setPromptText("Favorite Team");

        // Create a button to display fan information
        displayButton = new Button("Display");
        displayButton.setOnAction(e -> displayFanInfo());  // Set action to display fan info

        // Create a button to update fan information
        updateButton = new Button("Update");
        updateButton.setOnAction(e -> updateFanInfo());  // Set action to update fan info

        // Set up the layout of the UI components in a vertical box (VBox)
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().addAll(instructionLabel, instructionsArea, fanIdField, firstNameField, lastNameField, favoriteTeamField, displayButton, updateButton);

        // Set up the scene with the root layout and give it a size
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Fan Information App");  // Set the window title
        primaryStage.setScene(scene);  // Set the scene to the stage
        primaryStage.show();  // Show the window
    }

    // Method to display the fan information based on the provided fan ID
    private void displayFanInfo() {
        // Get the fan ID entered by the user
        String fanId = fanIdField.getText();

        // Validate if the fan ID is numeric
        if (fanId.isEmpty() || !fanId.matches("\\d+")) {
            showAlert("Invalid Input", "Please enter a valid numeric Fan ID.");
            return;
        }

        // Parse the fan ID into an integer and validate the range (1 to 12)
        int id = Integer.parseInt(fanId);
        if (id < 1 || id > 12) {
            showAlert("Invalid ID", "Fan ID must be between 1 and 12.");
            return;
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // SQL query to fetch fan details based on the fan ID
            String query = "SELECT * FROM fans WHERE ID = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);  // Set the fan ID parameter for the query
                ResultSet rs = stmt.executeQuery();
                // If the fan ID exists, populate the text fields with the fan details
                if (rs.next()) {
                    firstNameField.setText(rs.getString("firstname"));
                    lastNameField.setText(rs.getString("lastname"));
                    favoriteTeamField.setText(rs.getString("favoriteteam"));
                } else {
                    showAlert("No Record Found", "No fan found with ID " + id + ".");
                }
            }
        } catch (SQLException e) {
            showAlert("Database Error", "Error accessing the database.");
            e.printStackTrace();
        }
    }

    // Method to update fan information in the database
    private void updateFanInfo() {
        // Get the fan ID entered by the user
        String fanId = fanIdField.getText();

        // Validate if the fan ID is numeric
        if (fanId.isEmpty() || !fanId.matches("\\d+")) {
            showAlert("Invalid Input", "Please enter a valid numeric Fan ID.");
            return;
        }

        // Parse the fan ID into an integer and validate the range (1 to 12)
        int id = Integer.parseInt(fanId);
        if (id < 1 || id > 12) {
            showAlert("Invalid ID", "Fan ID must be between 1 and 12.");
            return;
        }

        // Get the updated fan information from the text fields
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String favoriteTeam = favoriteTeamField.getText();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // SQL query to update fan details based on the fan ID
            String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, favoriteTeam);
                stmt.setInt(4, id);  // Set the fan ID parameter for the update query
                int rowsUpdated = stmt.executeUpdate();
                // Show a success message if the update was successful
                if (rowsUpdated > 0) {
                    showAlert("Update Successful", "Fan information updated successfully!");
                } else {
                    showAlert("Update Failed", "Failed to update fan information.");
                }
            }
        } catch (SQLException e) {
            showAlert("Database Error", "Error updating the database.");
            e.printStackTrace();
        }
    }

    // Method to display alert messages to the user
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);  // No header for the alert
        alert.setContentText(message);  // Set the content of the alert
        alert.showAndWait();  // Show the alert and wait for user interaction
    }
}
