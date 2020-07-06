package com.maks.library.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateNewAccount extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CreateNewAccScreen.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Create New Account");
        stage.setResizable(false);
        stage.show();
    }
}
