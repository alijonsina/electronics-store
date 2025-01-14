package com.example.javaproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultiPageSignUp {

    private Stage primaryStage; // To switch between scenes
    private String selectedUserType; // Store the selected user type

    // Constructor to initialize primaryStage
    public MultiPageSignUp(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene createScene(Stage primaryStage) {
        // Title Label
        Label titleLabel = new Label("Select User Type");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Buttons for User Types
        Button adminButton = new Button("Admin");
        Button managerButton = new Button("Manager");
        Button cashierButton = new Button("Cashier");

        // Set actions for each button
        adminButton.setOnAction(e -> {
            selectedUserType = "Administrator";
            PageNavigation.showSignUpPage(selectedUserType);
        });

        managerButton.setOnAction(e -> {
            selectedUserType = "Manager";
            PageNavigation.showSignUpPage(selectedUserType);
        });

        cashierButton.setOnAction(e -> {
            selectedUserType = "Cashier";
            PageNavigation.showSignUpPage(selectedUserType);
        });

        // Layout
        VBox layout = new VBox(15, titleLabel, cashierButton, managerButton, adminButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        // Scene and Stage
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("User Type Selection");
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }

}

