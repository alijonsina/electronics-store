package Main;

import View.PageNavigation;
import javafx.application.Application;
import javafx.stage.Stage;
import DataAccessObject.UserFileAccess;

public class ElectronicStoreApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        UserFileAccess dao = new UserFileAccess();
        this.primaryStage = primaryStage;
        PageNavigation.setPrimaryStage(primaryStage);
        PageNavigation.showMultiLogInView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}