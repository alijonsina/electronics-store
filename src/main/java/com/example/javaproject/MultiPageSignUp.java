package com.example.javaproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultiPageSignUp  {

    private Stage primaryStage; // To switch between scenes
    private String selectedUserType; // Store the selected user type


    public Scene createScene(Stage primaryStage) {
        // Title Label
        Label titleLabel = new Label("Select User Type");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Buttons for User Types
        Button adminButton = new Button("Admin");
        Button userButton = new Button("User");
        Button guestButton = new Button("Guest");

        // Set actions for each button
        adminButton.setOnAction(e -> {
            selectedUserType = "Admin";
            //showSignUpPage();
        });

        userButton.setOnAction(e -> {
            selectedUserType = "User";
            //showSignUpPage();
        });

        guestButton.setOnAction(e -> {
            selectedUserType = "Guest";
            //showSignUpPage();
        });

        // Layout
        VBox layout = new VBox(15, titleLabel, adminButton, userButton, guestButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        // Scene and Stage
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("User Type Selection");
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }

    private void showSignUpPage() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.setUserType(selectedUserType);
        signUpPage.start(primaryStage);
    }


}