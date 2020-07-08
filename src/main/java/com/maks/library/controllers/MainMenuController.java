package com.maks.library.controllers;

import com.maks.library.DemoDataGenerator;
import com.maks.library.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import static com.maks.library.ScreenManager.*;


public class MainMenuController {

    @FXML
    Pane mainMenuPane;

    public void initialize() {

    }

    @FXML
    public void onLoginButtonClick(MouseEvent mouseEvent) {
        ScreenManager.getInstance().activate(Screen.LOGIN_MENU);
    }

    @FXML
    public void onCreateAccountButtonClick(MouseEvent mouseEvent) {
        ScreenManager.getInstance().activate(Screen.NEW_ACCOUNT_MENU);
    }

    @FXML
    public void onExitButtonClick(MouseEvent mouseEvent) {
        System.exit(1);
    }
}
