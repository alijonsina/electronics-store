package com.example.javaproject;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class CashierMainMenu {

    private Stage primaryStage;
    private String userType;

    public Scene createScene(Stage primaryStage) {

        // Create User Info Button for the menu
        MenuButton menuButton = new MenuButton("User Info");

        // Create MenuItems
        MenuItem viewUserInfo = new MenuItem("View User Info");
        MenuItem logOut = new MenuItem("Log Out");

        // Add action handlers
        viewUserInfo.setOnAction(e -> {
            System.out.println("Viewing user info...");
        });

        logOut.setOnAction(e -> {
            System.out.println("Logging out...");
        });

        // Add MenuItems to the MenuButton
        menuButton.getItems().addAll(viewUserInfo, logOut);

        // Create three buttons for center-left, center, and center-right
        Button leftButton = new Button("Left Button");
        Button centerButton = new Button("Center Button");
        Button rightButton = new Button("Right Button");

        // Create the layout using BorderPane
        BorderPane borderPane = new BorderPane();

        // Add padding to the BorderPane (push contents away from the borders)
        borderPane.setPadding(new Insets(20)); // Adds 20 pixels of padding on all sides

        // Place the MenuButton in the top-left corner
        borderPane.setTop(menuButton);

        // Place the buttons in the appropriate positions
        borderPane.setLeft(leftButton);   // Center-left button
        borderPane.setCenter(centerButton);  // Center button
        borderPane.setRight(rightButton);  // Center-right button

        // Set the scene and stage
        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setTitle("User Dropdown Menu Page");
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }
}
