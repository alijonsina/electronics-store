package com.example.javaproject;

import javafx.scene.Scene;
import javafx.stage.Stage;

/*This class exists to make the code more modular and clean.
We move all the page navigations to this class so that all the other classes
only call the methods rather than implementing them in the class */

public final class PageNavigation {

    private static Stage primaryStage; // Shared primaryStage for navigation

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void showMultiPageSignUp() {
        MultiPageSignUp multiSignUp = new MultiPageSignUp(primaryStage);
        Scene scene = multiSignUp.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Select User Type");
        primaryStage.show();
    }

    public static void showSignUpPage(String selectedUserType) {
        SignUpPage signUpPage = new SignUpPage(selectedUserType);
        Scene scene = signUpPage.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Log in as " + selectedUserType);
        primaryStage.show();
    }

    public static void showMainMenu(String userType) {
        switch (userType) {
            case "Cashier" -> showCashierMenu();
            case "Manager" -> showManagerMenu();
            case "Administrator" -> showAdminMenu();
            default -> showCashierMenu();//If something wrong happens, automatically sign in as cashier to prevent any security breaches.
        }
    }

    public static void showCashierMenu() {
        CashierMainMenu cashMainMenu = new CashierMainMenu();
        Scene scene = cashMainMenu.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cashier");
        primaryStage.show();
    }

    public static void showManagerMenu() {
        ManagerMainMenu manMainMenu = new ManagerMainMenu();
        Scene scene = manMainMenu.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Manager");
        primaryStage.show();
    }

    public static void showAdminMenu() {
        AdministratorMainMenu adminMainMenu = new AdministratorMainMenu();
        Scene scene = adminMainMenu.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Administrator");
        primaryStage.show();
    }
}
