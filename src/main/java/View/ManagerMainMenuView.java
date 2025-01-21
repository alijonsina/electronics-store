package View;

import Controller.CashierMainMenuControl;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerMainMenuView {


    public Scene createScene(Stage primaryStage) {

        // Create User Info Button for the menu
        MenuButton menuButton = new MenuButton("User Info");

        // Create MenuItems
        MenuItem viewUserInfo = new MenuItem("View User Info");
        MenuItem logOut = new MenuItem("Log Out");

        // Add action handlers
        viewUserInfo.setOnAction(e -> {
            System.out.println("Viewing user info...");
        });

//        logOut.setOnAction(e -> {
//            CashierMainMenuControl controller = null;
//            try {
//                controller = new ManagerMainMenuControl();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            } catch (ClassNotFoundException ex) {
//                throw new RuntimeException(ex);
//            }
//            controller.handleLogOut();
//        });

        // Add MenuItems to the MenuButton
        menuButton.getItems().addAll(viewUserInfo, logOut);

        // Create three buttons for center-left, center, and center-right
        Button leftButton = new Button("Left Button");
        Button rightButton = new Button("Right Button");

        // Add buttons in a horizontal choice bar
        HBox buttons = new HBox(leftButton, rightButton);

        // Create the layout using BorderPane

        BorderPane borderPane = new BorderPane();

        // Add padding to the BorderPane (push contents away from the borders)
        borderPane.setPadding(new Insets(20)); // Adds 20 pixels of padding on all sides

        // Place the MenuButton in the top-left corner
        borderPane.setTop(menuButton);

        // Place the buttons in the appropriate positions
        borderPane.setCenter(buttons);  // Center button

        // Set the scene and stage
        Scene scene = new Scene(borderPane, 400, 200);
        return scene;
    }
}
