package com.maks.library.controllers;

import com.maks.library.ScreenManager;
import com.maks.library.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class CreateNewAccountController {

    private static UserService userService = UserService.getInstance();

    @FXML
    TextField firstNameTextField;

    @FXML
    TextField lastNameTextField;

    @FXML
    TextField loginTextField;

    @FXML
    TextField passwordTextField; // TODO: 07/07/2020 zamienic na passwordfield

    public static void initialize() {
    }

    @FXML
    public void onSignUpButtonClick(MouseEvent mouseEvent) {
        String login = loginTextField.getText();
        if (!userService.isLoginTaken(login)) {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String password = passwordTextField.getText();

            userService.register(firstName, lastName, login, password);
            // TODO: 07/07/2020 wyswietl alert, ze konto utworzone

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Login is already taken!");
            alert.showAndWait();
        }
    }

    @FXML
    public void onCancelButtonClick(MouseEvent mouseEvent) {
        ScreenManager.getInstance().activate(ScreenManager.Screen.MAIN_MENU);
    }
}
