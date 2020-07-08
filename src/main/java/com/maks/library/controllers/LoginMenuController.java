package com.maks.library.controllers;

import com.maks.library.CurrentUser;
import com.maks.library.Main;
import com.maks.library.ScreenManager;
import com.maks.library.WrongCredentialsException;
import com.maks.library.database.model.User;
import com.maks.library.database.repository.UserRepository;
import com.maks.library.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class LoginMenuController {

    private static UserService userService = UserService.getInstance();

    @FXML
    public Pane loginMenuPane;

    @FXML
    TextField loginTextField;

    @FXML
    PasswordField passwordTextField;

    public static void initialize() {
    }

    @FXML
    public void onReturnClickButton(MouseEvent mouseEvent) {
        ScreenManager.getInstance().activate(ScreenManager.Screen.MAIN_MENU);
    }

    @FXML
    public void onLoginButtonClick(MouseEvent mouseEvent) {
        String login = loginTextField.getText();
        String password = passwordTextField.getText();

        try {
            User user = userService.login(login, password);
            CurrentUser.getInstance().setUser(user);

            switch (user.getRoleId()) {
                case 2: openAdminMenu(); break;
                case 3:  break;
                default: System.out.println("Bledna rola");
            }

        } catch (WrongCredentialsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong credentials!");
            alert.showAndWait();
        }
    }

    private void openAdminMenu() {
        ScreenManager.getInstance().activate(ScreenManager.Screen.ADMIN_MENU);
    }


}
