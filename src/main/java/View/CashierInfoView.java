package View;

import Controller.CashierInfoController;
import Model.Cashier;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CashierInfoView {

    private Cashier cashier;
    private CashierInfoController control = new CashierInfoController();


    public CashierInfoView(Cashier cashier) {this.cashier = cashier;}

    public Scene createScene(Stage primaryStage) {

        Label sectorLabel = new Label("Sector:" + cashier.getSectorCode());
        Label nameLabel = new Label("Name: " + cashier.getName() + cashier.getSurname());
        Label emailLabel = new Label("E-mail: " + cashier.getEmail());
        Label dateOfBirthLabel = new Label("Born: " + cashier.getDateOfBirth().getDay() + "/" + cashier.getDateOfBirth().getMonth() + "/" + cashier.getDateOfBirth().getYear());
        Label phoneNrLabel = new Label(cashier.getPhoneNr() + "");
        Label salaryLabel = new Label(cashier.getSalary() + "");

        Button changePasswordButton = new Button("Change Password");
        Button backButton = new Button("Back");

        changePasswordButton.setOnAction(e -> {
            try {
                control.handleChangePasswordButton(cashier.getUsername());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }        });

        backButton.setOnAction(e -> {
            try {
                control.handleBackButton(cashier.getUsername());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(1, sectorLabel);
        grid.addRow(2, nameLabel);
        grid.addRow(3, emailLabel);
        grid.addRow(4, phoneNrLabel);
        grid.addRow(5, dateOfBirthLabel);
        grid.addRow(6, salaryLabel);
        grid.addRow(7, changePasswordButton, backButton);

        // Set padding and alignment
        grid.setPadding(new Insets(10));
        grid.setStyle("-fx-font-size: 14px;");

        Scene scene = new Scene(grid, 400, 300);
        return scene;
    }
}
