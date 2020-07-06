package com.maks.library.controllers;

import com.maks.library.Main;
import com.maks.library.database.model.User;
import com.maks.library.database.repository.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class LoginMenuController {

    private static UserRepository userRepository = UserRepository.getInstance();
    private static Optional<User> currentUser = null;

    @FXML
    public Pane loginMenuPane;

    @FXML
    PasswordField loginTextArea;

    @FXML
    PasswordField passwordTextArea;

    public static void initialize() {
    }

    @FXML
    public void onReturnClickButton(MouseEvent mouseEvent) {
        try {
            new MainMenu().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onLoginButtonClick(MouseEvent mouseEvent) {
        userRepository.findByLoginAndPassword(loginTextArea.getText(), passwordTextArea.getText()).ifPresent(user -> {
            currentUser = Optional.of(user);

            switch (user.getRoleId()) {
                case 2: try {
                    new AdminMenu().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                } break;
                case 3:  break;
                default: System.out.println("Bledna rola");
            }
        });
    }


}
