package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ManagerInfoView {
    private Manager manager;


    public CashierInfoView(Manager manager) {
        this.Manager = manager;
    }

    public Scene createScene(Stage primaryStage) {

        Label nameLabel = new Label("Name: " + manager.name + manager.surname);
        Label emailLabel = new Label("E-mail: " + manager.email);
        Label dateOfBirthLabel = new Label("Born: " + manager.dateOfBirth.getDay() + "/" + manager.dateOfBirth.getMonth() + "/" + manager.dateOfBirth.getYear());
        Label phoneNrLabel = new Label(manager.phoneNr + "");
        Label salaryLabel = new Label(manager.salary + "");

        Button changePasswordButton = new Button("Change Password");
        Button backButton = new Button("Back");

        changePasswordButton.setOnAction(e -> {

        });

        backButton.setOnAction(e -> {

        });

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(1, nameLabel);
        grid.addRow(2, emailLabel);
        grid.addRow(3, phoneNrLabel);
        grid.addRow(4, dateOfBirthLabel);
        grid.addRow(5, salaryLabel);
        grid.addRow(6, changePasswordButton, backButton);

        // Set padding and alignment
        grid.setPadding(new Insets(10));
        grid.setStyle("-fx-font-size: 14px;");

        Scene scene = new Scene(grid, 400, 300);

        return scene;
    }
}
