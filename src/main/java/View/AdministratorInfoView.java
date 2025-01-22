package View;

import Controller.AdministratorInfoController;
import Model.Administrator;
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
        Label dateOfBirthLabel = new Label("Born: " + admin.getDateOfBirth().getDayOfYear() + "/" + admin.getDateOfBirth().getMonth() + "/" + admin.getDateOfBirth().getYear());
        Label phoneNrLabel = new Label(admin.getPhoneNr() + "");
        Label salaryLabel = new Label(admin.getSalary() + "");

        Button changePasswordButton = new Button("Change Password");
        Button backButton = new Button("Back");

        changePasswordButton.setOnAction(e -> {
            try {
                control.handleChangePasswordButton(admin.getUsername());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        backButton.setOnAction(e -> {
            try {
                control.handleBackButton(admin.getUsername());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
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
