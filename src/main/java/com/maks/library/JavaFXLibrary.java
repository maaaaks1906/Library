package com.maks.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

import static com.maks.library.ScreenManager.*;

public class JavaFXLibrary extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL main = getClass().getResource("/fxml/MainMenuScreen.fxml");
        URL login = getClass().getResource("/fxml/LoginMenuScreen.fxml");
        URL createNewAccount = getClass().getResource("/fxml/CreateNewAccScreen.fxml");
        URL adminMenu = getClass().getResource("/fxml/AdminMenuScreen.fxml");
        URL bookDetailMenu = getClass().getResource("/fxml/BookDetailScreen.fxml");

        Pane mainMenuScreen = FXMLLoader.load(main);

        Scene scene = new Scene(mainMenuScreen);

        ScreenManager screenManager = getInstance();
        screenManager.addScreen(Screen.MAIN_MENU, main);
        screenManager.addScreen(Screen.LOGIN_MENU, login);
        screenManager.addScreen(Screen.ADMIN_MENU, adminMenu);
        screenManager.addScreen(Screen.NEW_ACCOUNT_MENU, createNewAccount);
        screenManager.addScreen(Screen.BOOK_DETAIL_MENU, bookDetailMenu);

        ScreenManager.setStage(stage);
        ScreenManager.setMain(scene);
        screenManager.activate(Screen.MAIN_MENU);

        stage.setScene(scene);
        stage.setTitle("JavaFX Library");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        DemoDataGenerator.generateDemoData();

        launch(args);
    }

}

