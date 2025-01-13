package com.example.javaproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showMultiPageLogin();
    }

    private void showMultiPageLogin() {
        MultiPageSignUp multiLogIn = new MultiPageSignUp();
        Scene loginScene = multiLogIn.createScene(primaryStage);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
