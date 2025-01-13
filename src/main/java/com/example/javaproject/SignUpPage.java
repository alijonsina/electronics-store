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

    public void setUserType(String userType) {
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

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 10px;");

        Label messageLabel = new Label();

        // Set button action
        signUpButton.setOnAction(e -> {
            try {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String email = emailField.getText();
                if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    throw new EmptyFieldException();
                }
            } catch (EmptyFieldException ex) {
                messageLabel.setText("All fields are required!");
                messageLabel.setStyle("-fx-text-fill: red;");
            }
        });

        // Back Button to return to the user type selection screen
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            showMultiPageLogin();
        });

        // Layout the elements
        VBox layout = new VBox(10, titleLabel, usernameField, passwordField, emailField, signUpButton, backButton, messageLabel);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Set up the scene
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Sign Up Page");
        primaryStage.setScene(scene);
        primaryStage.show();

        return scene;  // Return the scene for possible future use
    }

    private void showMultiPageLogin() {
        MultiPageSignUp multiLogIn = new MultiPageSignUp(primaryStage); // Pass primaryStage here
        Scene loginScene = multiLogIn.createScene();
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }
}
