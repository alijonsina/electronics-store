package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdministratorInfoView {

    private Administrator administrator;


    public CashierInfoView(Administrator administrator, ) {
        this.administrator = administrator;
    }

    public Scene createScene(Stage primaryStage) {

        Label nameLabel = new Label("Name: " + administrator.name + administrator.surname);
        Label emailLabel = new Label("E-mail: " + administrator.email);
        Label dateOfBirthLabel = new Label("Born: " + administrator.dateOfBirth.getDay() + "/" + administrator.dateOfBirth.getMonth() + "/" + administrator.dateOfBirth.getYear());
        Label phoneNrLabel = new Label(administrator.phoneNr + "");
        Label salaryLabel = new Label(administrator.salary + "");

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
