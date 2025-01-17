package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CashierInfoView {

    private Cashier cashier;


    public CashierInfoView(Cashier cashier, ) {
        this.cashier = cashier;
    }

    public Scene createScene(Stage primaryStage) {

        Label sectorLabel = new Label("Sector:" + cashier.sectorCode);
        Label nameLabel = new Label("Name: " + cashier.name + cashier.surname);
        Label emailLabel = new Label("E-mail: " + cashier.email);
        Label dateOfBirthLabel = new Label("Born: " + cashier.dateOfBirth.getDay() + "/" + cashier.dateOfBirth.getMonth() + "/" + cashier.dateOfBirth.getYear());
        Label phoneNrLabel = new Label(cashier.phoneNr + "");
        Label salaryLabel = new Label(cashier.salary + "");

        Button changePasswordButton = new Button("Change Password");
        Button backButton = new Button("Back");

        changePasswordButton.setOnAction(e -> {

        });

        backButton.setOnAction(e -> {

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
