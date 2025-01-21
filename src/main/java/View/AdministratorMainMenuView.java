package View;

import Controller.AdministratorMainMenuControl;
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

public class AdministratorMainMenuView {

    private AdministratorMainMenuControl control;

    public AdministratorMainMenuView(String username) throws IOException, ClassNotFoundException {
        control = new AdministratorMainMenuControl(username);
    }

    public Scene createScene(Stage primaryStage) {

        // Create User Info Button for the menu
        MenuButton menuButton = new MenuButton("User Info");

        // Create MenuItems
        MenuItem viewUserInfo = new MenuItem("View User Info");
        MenuItem logOut = new MenuItem("Log Out");

        // Add action handlers
        viewUserInfo.setOnAction(e -> {
            control.handleViewUserInfo();
        });

        logOut.setOnAction(e -> {
            control.handleLogOut();
        });

        // Add MenuItems to the MenuButton
        menuButton.getItems().addAll(viewUserInfo, logOut);

        // Create three buttons for center-left, center, and center-right
        Button createBillButton = new Button("Create a New Bill");
        Button viewBillsButton = new Button("View Today's Bills");

        // Create the layout using BorderPane
        BorderPane borderPane = new BorderPane();

        // Create button layout using VBox
        HBox hbox = new HBox(15,  createBillButton, viewBillsButton);

        // Place the MenuButton in the top-left corner
        borderPane.setTop(menuButton);

        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));

        borderPane.setCenter(hbox);

        // Set the scene and stage
        Scene scene = new Scene(borderPane, 300, 200);

        return scene;
    }
}
