package Main;

import Model.*;
import View.PageNavigation;
import javafx.application.Application;
import javafx.stage.Stage;
import DataAccessObject.UserFileAccess;

import java.io.IOException;
import java.util.Date;

public class ElectronicStoreApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        UserFileAccess dao = new UserFileAccess();
        try {
            dao.createNewUserFile();
            Administrator admin = new Administrator(
                    "admin01",
                    "adminPass",
                    "John",
                    "Doe",
                    new Date(),
                    123456789,
                    "admin@example.com",
                    5000,
                    "Administrator"
            );
            System.out.println("Administrator created: " + admin.getUsername());

            // Test Cashier class
            Item[] items = {
                    new Item("Item1", 101, 10, 15, 1, 1),
                    new Item("Item2", 102, 20, 25, 1, 2)
            };
            Bill[] bills = {
                    new Bill(1, new Date(), new int[]{1, 2}, 40, items),
                    new Bill(2, new Date(), new int[]{3, 1}, 55, items)
            };
            Cashier cashier = new Cashier(
                    "cashier01",
                    "cashierPass",
                    "Jane",
                    "Smith",
                    new Date(),
                    987654321,
                    "cashier@example.com",
                    3000,
                    "Cashier",
                    2,
                    "SC01",
                    bills
            );
            System.out.println("Cashier created: " + cashier.getUsername() + ", Sector Code - " + cashier.getSectorCode());

            // Test Manager class
            Sector[] sectors = {
                    new Sector("Sector1", 1, null, items, new int[]{10}),
                    new Sector("Sector2", 2, null, items, new int[]{5})
            };
            Manager manager = new Manager(
                    "manager01",
                    "managerPass",
                    "Alice",
                    "Brown",
                    new Date(),
                    555123456,
                    "manager@example.com",
                    7000,
                    "Manager",
                    sectors
            );
            System.out.println("Manager created: " + manager.getUsername() + ", Number of Sectors - " + sectors.length);
            try {
                dao.addUser(cashier);
                dao.addUser(manager);
                dao.addUser(admin);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.primaryStage = primaryStage;
        PageNavigation.setPrimaryStage(primaryStage);
        PageNavigation.showMultiLogInView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}