package Main;

import Controller.PageNavigation;
import DataAccessObject.UserFileAccess;
import Model.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;


public class ElectronicStoreApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

//        UserFileAccess userFileAccess = new UserFileAccess();
//
//        Manager manager = new Manager("manager1", "password", "John", "Doe", LocalDate.of(1990, 5, 15), 123456789, "john.doe@example.com", 2500, "Manager");
//        Cashier cashier = new Cashier("cashier1", "password", "Jane", "Doe", LocalDate.of(1980, 2, 23), 23456789, "jane.doe@example.com", 5000, "Cashier", 12, "appliances");
//        try {
//            UserFileAccess userFileAccess1 = new UserFileAccess();
//            userFileAccess1.addUser(manager);
//            userFileAccess1.addUser(cashier);
//        } catch (IOException e) {
//            System.err.println("Error serializing objects: " + e.getMessage());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        this.primaryStage = primaryStage;
        PageNavigation.setPrimaryStage(primaryStage);
        PageNavigation.showMultiLogInView();
    }



    public static void main(String[] args) {
        launch(args);
    }
}