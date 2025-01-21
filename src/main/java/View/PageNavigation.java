package View;

import Model.Administrator;
import Model.Cashier;
import Model.Manager;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*This class exists to make the code more modular and clean.
We move all the page navigations to this class so that all the other classes
only call the methods rather than implementing them.*/

public final class PageNavigation {

    private static Stage primaryStage; // Shared primaryStage for navigation

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
            case "Manager" -> showManagerMenuView();
            case "Administrator" -> showAdministratorMenuView();
            default -> showCashierMenuView(username);//If something wrong happens, automatically sign in as cashier to prevent any security breaches.
        }
    }

    public static void showCashierMenuView(String username) throws IOException, ClassNotFoundException {
        CashierMainMenuView cashMainMenu = new CashierMainMenuView(username);
        Scene scene = cashMainMenu.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cashier");
        primaryStage.show();
    }

    public static void showManagerMenuView() {
        ManagerMainMenuView manMainMenu = new ManagerMainMenuView();
        Scene scene = manMainMenu.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Manager");
        primaryStage.show();
    }

    public static void showAdministratorMenuView() {
        AdministratorMainMenuView adminMainMenu = new AdministratorMainMenuView();
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
}