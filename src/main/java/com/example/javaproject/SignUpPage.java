package com.example.javaproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpPage {

    private Stage primaryStage;
    private String userType;

    public SignUpPage(String userType) {
        this.userType = userType;
    }

    // Create the sign-up scene
    public Scene createScene(Stage primaryStage) {
        this.primaryStage = primaryStage;  // Assign the primaryStage

        // Create the UI elements
        Label titleLabel = new Label("Sign Up as " + (userType != null ? userType : "User"));
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 10px;");

        Label messageLabel = new Label();

        // Set button action
        signUpButton.setOnAction(e -> {
            try {
                String username = usernameField.getText();
                String password = passwordField.getText();
                if (username.isEmpty() || password.isEmpty()) {
                    throw new EmptyFieldException();
                } else {
                    switch ("Sign Up Authorized") {
                        case "User does not exist" -> {messageLabel.setText("User does not exist"); messageLabel.setStyle("-fx-text-fill: red;");}
                        case "Incorrect Password" -> {messageLabel.setText("Incorrect Password"); messageLabel.setStyle("-fx-text-fill: red;");}
                        case "Sign Up Authorized" -> PageNavigation.showMainMenu(userType);
                        default -> messageLabel.setText("Something went wrong");
                    };
                }

            } catch (EmptyFieldException ex) {
                messageLabel.setText("All fields are required!");
                messageLabel.setStyle("-fx-text-fill: red;");
            }
        });

        // Back Button to return to the user type selection screen
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> PageNavigation.showMultiPageSignUp());

        // Layout the elements
        VBox layout = new VBox(10, titleLabel, usernameField, passwordField, signUpButton, backButton, messageLabel);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Set up the scene
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Sign Up Page");
        primaryStage.setScene(scene);
        primaryStage.show();

        return scene;
    }

    public static void wait(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
