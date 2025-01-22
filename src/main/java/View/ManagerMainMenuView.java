package View;

import Controller.ManagerMainMenuControl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerMainMenuView {

    private ManagerMainMenuControl control;

    public ManagerMainMenuView(String username) throws IOException, ClassNotFoundException {
        try {
            control = new ManagerMainMenuControl(username);
        } catch (IllegalArgumentException | ClassCastException e) {
            System.err.println("Error initializing ManagerMainMenuControl: " + e.getMessage());
            throw e;
        }
    }

    public Scene createScene(Stage primaryStage) {
        MenuButton menuButton = new MenuButton("User Info");
        MenuItem viewUserInfo = new MenuItem("View User Info");
        MenuItem logOut = new MenuItem("Log Out");

        viewUserInfo.setOnAction(e -> control.handleViewUserInfo());
        logOut.setOnAction(e -> control.handleLogOut());

        menuButton.getItems().addAll(viewUserInfo, logOut);

        Button viewStockButton = new Button("View Stock");
        Button viewCashierPerformanceButton = new Button("Cashier Performance");

        BorderPane borderPane = new BorderPane();
        HBox hbox = new HBox(15, viewStockButton, viewCashierPerformanceButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));

        borderPane.setTop(menuButton);
        borderPane.setCenter(hbox);

        viewStockButton.setOnAction(e -> control.handleViewStock());

        return new Scene(borderPane, 300, 200);
    }
}