package com.maks.library.controllers;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminMenuController {

    public void onLogoutButtonClick(MouseEvent mouseEvent) {
        try {
            new MainMenu().start(new Stage());
            new LoginMenu().stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onExitButtonClick(MouseEvent mouseEvent) {
        System.exit(1);
    }
}
