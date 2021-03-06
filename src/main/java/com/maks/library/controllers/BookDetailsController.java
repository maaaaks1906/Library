package com.maks.library.controllers;

import com.maks.library.ScreenManager;
import com.maks.library.database.model.Book;
import com.maks.library.database.model.Genre;
import com.maks.library.service.BookService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class BookDetailsController {

    @FXML
    TextArea bookDetailTextArea;

    @FXML
    TextField titleTextField;

    @FXML
    TextField genreTextField;

    @FXML
    Button returnButton;

    public static Book book;

    public BookService bookService = BookService.getInstance();

    private static BookDetailsController INSTANCE = null;
    
    public static BookDetailsController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookDetailsController();
        }
        
        return INSTANCE;
    }

    public void initialize() {
        bookDetailTextArea.setText(book.getTitle() + book.getYear() + book.getGenreId());
        bookDetailTextArea.setEditable(false);

        titleTextField.setText(book.getTitle());

        Genre genre = bookService.findGenreById(book.getGenreId());
        genreTextField.setText(genre.getGenre());
        // TODO: 13/07/2020 dokonczyc
    }

    public void onReturnButtonClick(MouseEvent mouseEvent) {
        ScreenManager screenManager = ScreenManager.getInstance();
        screenManager.activate(ScreenManager.Screen.ADMIN_MENU);
        screenManager.removeScreen(ScreenManager.Screen.BOOK_DETAIL_MENU);

        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }

    public void start(Stage stage) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("/fxml/BookDetailScreen.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Book details");
        stage.setResizable(false);
        stage.show();
    }
}
