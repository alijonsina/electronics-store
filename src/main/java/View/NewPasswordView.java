package View;

import Controller.NewPasswordViewController;
import Exceptions.EmptyFieldException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class NewPasswordView {

    private String userType;
    private String username;
    private NewPasswordViewController control = new NewPasswordViewController();

    public NewPasswordView(String userType, String username) {
        this.userType = userType;
        this.username = username;
    }
    public Scene createScene(Stage secondaryStage) {

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");

        Button confirm = new Button("Confirm");
        confirm.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 10px;");
        VBox layout = new VBox(10, passwordField, confirmPasswordField, confirm);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Label messageLabel = new Label();

        confirm.setOnAction(e -> {
            try {
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                String result = control.handleNewPassword(username, password, confirmPassword);
                if (!result.equals("Select new password")) {
                    messageLabel.setText(result);
                    messageLabel.setStyle("-fx-text-fill: red;");
                }
                secondaryStage.close();

            } catch (EmptyFieldException ex) {
                messageLabel.setText("All fields are required!");
                messageLabel.setStyle("-fx-text-fill: red;");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Scene changePasswordScene = new Scene(layout, 300, 200); // Set the layout and dimensions
        return changePasswordScene;
    }
}
