package com.maks.library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ScreenManager {
    public enum Screen {
        MAIN_MENU, LOGIN_MENU, ADMIN_MENU, NEW_ACCOUNT_MENU, BOOK_DETAIL_MENU
    }

    private static ScreenManager INSTANCE = null;

    private static Map<Screen, URL> screens = new HashMap<>();
    private static Stage stage;
    private static Scene main;

    private ScreenManager() { }

    public static ScreenManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScreenManager();
        }

        return INSTANCE;
    }

    public void addScreen(Screen screen, URL url){
        screens.put(screen, url);
    }

    public static void setMain(Scene main) {
        ScreenManager.main = main;
    }

    public static void setStage(Stage stage) {
        ScreenManager.stage = stage;
    }

    public void activate(Screen screen){
        try {
            Pane pane = FXMLLoader.load(screens.get(screen));

            stage.setWidth(pane.getPrefWidth());
            stage.setHeight(pane.getPrefHeight());
            main.setRoot(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeScreen(Screen screen) {
        screens.remove(screen);
    }
}
