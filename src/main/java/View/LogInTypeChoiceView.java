package View;

import Controller.LoginTypeControl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInTypeChoiceView {

    private Stage primaryStage; // To switch between scenes
    LoginTypeControl control;

    // Constructor to initialize primaryStage
    public LogInTypeChoiceView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        control = new LoginTypeControl();
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
            control.handleLoginType("Admin");
        });

        managerButton.setOnAction(e -> {
            control.handleLoginType("Manager");
        });

        cashierButton.setOnAction(e -> {
            control.handleLoginType("Cashier");
        });

        // Layout
        VBox layout = new VBox(15, titleLabel, cashierButton, managerButton, adminButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        // Scene and Stage
        Scene scene = new Scene(layout, 400, 300);
        return scene;
    }

}

