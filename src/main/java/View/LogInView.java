package View;

import Controller.LogInControl;
import Exceptions.EmptyFieldException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInView {

    private String userType;

    public LogInView(String userType) {
        this.userType = userType;
    }

    // Create the sign-up scene
    public Scene createScene(Stage primaryStage) {
        // Create the UI elements
        Label titleLabel = new Label("Log In as " + (userType != null ? userType : "User"));
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button signUpButton = new Button("Log In");
        signUpButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 10px;");

        Label messageLabel = new Label();

        // Set button action
        signUpButton.setOnAction(e -> {
            try {
                String username = usernameField.getText();
                String password = passwordField.getText();
                LogInControl controller = new LogInControl(userType);
                String result = controller.handleSignUp(username, password);

                if (result != null) {
                    messageLabel.setText(result);
                    messageLabel.setStyle("-fx-text-fill: red;");
                }

            } catch (EmptyFieldException ex) {
                messageLabel.setText("All fields are required!");
                messageLabel.setStyle("-fx-text-fill: red;");
            }
        });

        // Back Button to return to the user type selection screen
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> PageNavigation.showMultiLogInView());

        // Layout the elements
        VBox layout = new VBox(10, titleLabel, usernameField, passwordField, signUpButton, backButton, messageLabel);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Set up the scene
        Scene scene = new Scene(layout, 400, 300);

        return scene;
    }

}