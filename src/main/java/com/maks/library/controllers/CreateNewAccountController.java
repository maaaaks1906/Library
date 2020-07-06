package com.maks.library.controllers;

import com.maks.library.database.model.User;
import com.maks.library.database.repository.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class CreateNewAccountController {

    private static UserRepository userRepository = UserRepository.getInstance();

    @FXML
    Pane newAccountPane;

    @FXML
    TextField nameTextField;

    @FXML
    TextField lastNameTextField;

    @FXML
    TextField loginTextField;

    @FXML
    TextField passwordTextField;

    public static void initialize() {
    }

    @FXML
    public void onSignUpButtonClick(MouseEvent mouseEvent) {
        if (userRepository.findByLogin(loginTextField.getText()).isPresent()) { // TODO: 06/07/2020 nullpointer

        } else {
            userRepository.save(new User(
                    nameTextField.getText(),
                    lastNameTextField.getText(),
                    loginTextField.getText(),
                    passwordTextField.getText(),
                    3));

            System.out.println();
            System.out.println("+++++++++++++Konto utworzone+++++++++++++");
        }
    }

    @FXML
    public void onCancelButtonClick(MouseEvent mouseEvent) {
        try {
            new MainMenu().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
