package com.maks.library.controllers;

import com.maks.library.DemoDataGenerator;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;


public class MainMenuController {

    @FXML
    Pane mainMenuPane;

    public void initialize() {
        DemoDataGenerator.generateDemoData();
    }

    @FXML
    public void onLoginButtonClick(MouseEvent mouseEvent) {
        try {
            new LoginMenu().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onCreateAccountButtonClick(MouseEvent mouseEvent) {
        try {
            new CreateNewAccount().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onExitButtonClick(MouseEvent mouseEvent) {
        System.exit(1);
    }
}
