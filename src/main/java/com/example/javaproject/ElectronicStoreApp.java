package com.example.javaproject;

import javafx.application.Application;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        PageNavigation.setPrimaryStage(primaryStage);
        PageNavigation.showMultiPageSignUp();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

