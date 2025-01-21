package View;

import Controller.AdministratorInfoController;
import Controller.AdministratorMainMenuControl;
import Controller.ManagerInfoController;
import Model.Administrator;
import Model.Manager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class AdministratorInfoView {

    private Administrator admin;
    private AdministratorInfoController control = new AdministratorInfoController();


    public AdministratorInfoView(Administrator administrator) {
        this.admin = administrator;
    }

    public Scene createScene(Stage primaryStage) {

        Label nameLabel = new Label("Name: " + admin.getName() + admin.getSurname());
        Label emailLabel = new Label("E-mail: " + admin.getEmail());
        Label dateOfBirthLabel = new Label("Born: " + admin.getDateOfBirth().getDay() + "/" + admin.getDateOfBirth().getMonth() + "/" + admin.getDateOfBirth().getYear());
        Label phoneNrLabel = new Label(admin.getPhoneNr() + "");
        Label salaryLabel = new Label(admin.getSalary() + "");

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
