package Main;

import Controller.PageNavigation;
import DataAccessObject.UserFileAccess;
import Model.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class ElectronicStoreApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        UserFileAccess userFileAccess = new UserFileAccess();

        // Create sample users
        Administrator admin = new Administrator("admin1", "password", "James", "Carol", LocalDate.of(1970, 4, 26), 123456789, "james.carol@example.com", 2500, "Admin");
        Manager manager = new Manager("manager1", "password", "John", "Doe", LocalDate.of(1990, 5, 15), 123456789, "john.doe@example.com", 2500, "Manager");
        Cashier cashier = new Cashier("cashier1", "password", "Jane", "Doe", LocalDate.of(1980, 2, 23), 23456789, "jane.doe@example.com", 5000, "Cashier", 12, "appliances");

        try {

            userFileAccess.addUser(manager);
            userFileAccess.addUser(cashier);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while adding users: " + e.getMessage());
        }

        // Start the primary application
        PageNavigation.setPrimaryStage(primaryStage);
        PageNavigation.showMultiLogInView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
