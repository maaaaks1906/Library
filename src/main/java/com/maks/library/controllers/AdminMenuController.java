package com.maks.library.controllers;

import com.maks.library.CurrentUser;
import com.maks.library.ScreenManager;
import com.maks.library.database.model.Book;
import com.maks.library.database.model.User;
import com.maks.library.service.BookService;
import com.maks.library.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class AdminMenuController {

    private BookService bookService = BookService.getInstance();
    private UserService userService = UserService.getInstance();

    @FXML
    public ListView<Book> booksListView;

    @FXML
    public ListView<User> userListView;

    public void initialize() {
        List<Book> books = bookService.findAll();
        ObservableList<Book> observableBooksList = FXCollections.observableList(books);

        booksListView.setItems(observableBooksList);
        booksListView.setOnMouseClicked(this::onListItemClick);
        booksListView.setCellFactory(bookListView -> new ListCell<>() {
            @Override
            protected void updateItem(Book book, boolean empty) {
                super.updateItem(book, empty);

                if (book != null) {
                    setText(book.getTitle() + ", rok: " + book.getYear());
                }
            }
        });

        List<User> users = userService.findAll();
        ObservableList<User> userObservableList = FXCollections.observableList(users);
        userListView.setItems(userObservableList);
        userListView.setOnMouseClicked(this::onListItemClick);
        userListView.setCellFactory(userListView1 -> new ListCell<>() {
            protected void updateItem(User user, boolean empty) {
                super.updateItem(user, empty);

                if (user != null) {
                    setText("Name: " + user.getFirstName() + "Last name" +  user.getLastName());
                }
            }
        });
    }

    private void onListItemClick(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            Book selectedItem = booksListView.getSelectionModel().getSelectedItem();
            // todo utworz okno ze szczegolami o danej ksiazce
        }
    }

    public void onLogoutButtonClick(MouseEvent mouseEvent) {
        ScreenManager.getInstance().activate(ScreenManager.Screen.MAIN_MENU);
        CurrentUser.getInstance().setUser(null);
    }

    public void onExitButtonClick(MouseEvent mouseEvent) {
        System.exit(1);
    }
}
