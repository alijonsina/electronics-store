package Controller;

import Model.Administrator;
import Model.Cashier;
import Model.Manager;
import View.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class PageNavigation {

    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void showMultiLogInView() {
        LogInTypeChoiceView multiSignUp = new LogInTypeChoiceView(primaryStage);
        Scene scene = multiSignUp.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Select User Type");
        primaryStage.show();
    }

    public static void showLogInPage(String selectedUserType) {
        LogInView logInPage = new LogInView(selectedUserType);
        Scene scene = logInPage.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Log in as " + selectedUserType);
        primaryStage.show();
    }

    public static void showMainMenuView(String userType, String username) throws IOException, ClassNotFoundException {
        switch (userType) {
            case "Cashier" -> showCashierMenuView(username);
            case "Manager" -> showManagerMenuView(username);
            case "Admin" -> showAdministratorMenuView(username);
            default -> showCashierMenuView(username);
        }
    }

    public static void showCashierMenuView(String username) throws IOException, ClassNotFoundException {
        CashierMainMenuView cashMainMenu = new CashierMainMenuView(username);
        Scene scene = cashMainMenu.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cashier");
        primaryStage.show();
    }

    public static void showManagerMenuView(String username) throws IOException, ClassNotFoundException {
        try {
            ManagerMainMenuView manMainMenu = new ManagerMainMenuView(username);
            Scene scene = manMainMenu.createScene(primaryStage);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Manager");
            primaryStage.show();
        } catch (IllegalArgumentException | ClassCastException e) {
            System.err.println("Error loading manager menu: " + e.getMessage());
            showMultiLogInView();
        }
    }

    public static void showAdministratorMenuView(String username) throws IOException, ClassNotFoundException {
        AdministratorMainMenuView adminMainMenu = new AdministratorMainMenuView(username);
        Scene scene = adminMainMenu.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Administrator");
        primaryStage.show();
    }

    public static void showCashierInfo(Cashier cashier) {
        CashierInfoView cashierInfo = new CashierInfoView(cashier);
        Scene scene = cashierInfo.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle(cashier.getUsername());
        primaryStage.show();
    }

    public static void showManagerInfo(Manager manager) {
        ManagerInfoView managerInfo = new ManagerInfoView(manager);
        Scene scene = managerInfo.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle(manager.getUsername());
        primaryStage.show();
    }

    public static void showAdministratorInfo(Administrator admin) {
        AdministratorInfoView adminInfo = new AdministratorInfoView(admin);
        Scene scene = adminInfo.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle(admin.getUsername());
        primaryStage.show();
    }

    public static void showItemView(String username) {
        ItemController itemControl = new ItemController(username);
        Scene scene;
        try {
            scene = itemControl.getView().getScene();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        primaryStage.setScene(scene);
        primaryStage.setTitle(username);
        primaryStage.show();
    }
}