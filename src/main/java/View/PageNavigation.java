package View;

import Model.Cashier;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    public static void showMainMenuView(String userType) {
        switch (userType) {
            case "Cashier" -> showCashierMenuView();
            case "Manager" -> showManagerMenuView();
            case "Administrator" -> showAdminMenuView();
            default -> showCashierMenuView();//If something wrong happens, automatically sign in as cashier to prevent any security breaches.
        }
    }

    public static void showCashierMenuView() {
        CashierMainMenuView cashMainMenu = new CashierMainMenuView();
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

    public static void showAdminMenuView() {
        AdministratorMainMenuView adminMainMenu = new AdministratorMainMenuView();
        Scene scene = adminMainMenu.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Administrator");
        primaryStage.show();
    }

    public static void showCashierInfo(Cashier cashier) {
        CashierInfoView cashierInfo = new CashierInfo(cashier);
        Scene scene = cashierInfo.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle(cashier.username);
        primaryStage.show();
    }

    public static void showCashierInfo(Manager manager) {
        ManagerInfoView managerInfo = new ManagerInfo(manager);
        Scene scene = managerInfo.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle(manager.username);
        primaryStage.show();
    }

    public static void showCashierInfo(Administrator admin) {
        AdministratorInfoView adminInfo = new AdmnistratorInfo(admin);
        Scene scene = adminInfo.createScene(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle(admin.username);
        primaryStage.show();
    }
}
