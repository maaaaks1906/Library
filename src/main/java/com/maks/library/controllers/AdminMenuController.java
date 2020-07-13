package com.maks.library.controllers;

import com.maks.library.CurrentUser;
import com.maks.library.ScreenManager;
import com.maks.library.database.model.*;
import com.maks.library.database.repository.BookRepository;
import com.maks.library.service.AuthorService;
import com.maks.library.service.BookService;
import com.maks.library.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class AdminMenuController {

    private static AdminMenuController INSTANCE = null;

    public static AdminMenuController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdminMenuController();
        }

        return INSTANCE;
    }

    private BookService bookService = BookService.getInstance();
    private UserService userService = UserService.getInstance();
    private AuthorService authorService = AuthorService.getInstance();
    private BookRepository bookRepository = BookRepository.getInstance();

    @FXML
    public ListView<Book> booksListView;

    @FXML
    public ListView<User> userListView;

    @FXML
    public ListView<Lend> lendListView;
    
    @FXML
    public ListView<Book> searchResultListView;

    @FXML
    public ListView<Book> bookToLendListView;

    @FXML
    public TextField searchTextField;

    @FXML
    public TextField bookTitleTextField;

    @FXML
    public TextField bookAuthorTextField;

    @FXML
    public TextField bookYearTextField;

    @FXML
    public TextField findBookToLendTextField;

    @FXML
    public ChoiceBox<String> bookGenreChoiceBox;

    @FXML
    public ChoiceBox<String> searchByChoiceBox; // TODO: 10/07/2020   choicebox musi wybierac z listy kilku roznych klas

    public void initialize() {
        List<Book> books = bookService.findAll();
        ObservableList<Book> observableBooksList = FXCollections.observableList(books);

        booksListView.setItems(observableBooksList);
        booksListView.setOnMouseClicked(this::onBookListItemClick);
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
        userListView.setOnMouseClicked(this::onUserListItemClick);
        userListView.setCellFactory(userListView1 -> new ListCell<>() {
            protected void updateItem(User user, boolean empty) {
                super.updateItem(user, empty);

                if (user != null) {
                    setText("Name: " + user.getFirstName() + " Last name: " +  user.getLastName());
                }
            }
        });

        ObservableList<String> availableSearchOptions = FXCollections.observableList(Arrays.asList(
                "Title", "Author", "Genre", "Year"
                ));
        searchByChoiceBox.setItems(availableSearchOptions);

        ObservableList<String> availableGenres = FXCollections.observableList(Arrays.asList(
                "Education", "Sci-Fi", "Fantasy"
        ));
        bookGenreChoiceBox.setItems(availableGenres);
    }

    public void onBookListItemClick(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            BookDetailsController.book = booksListView.getSelectionModel().getSelectedItem();
            try {
                new BookDetailsController().start(new Stage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void onUserListItemClick(MouseEvent mouseEvent) {
        // TODO: 13/07/2020 dokonczyc
    }

    public void onLogoutButtonClick(MouseEvent mouseEvent) {
        ScreenManager.getInstance().activate(ScreenManager.Screen.MAIN_MENU);
        CurrentUser.getInstance().setUser(null);
    }

    public void onSearchButtonClick(MouseEvent mouseEvent) {
        List<Book> books = new ArrayList<>();
        String query = searchTextField.getText();

        switch (searchByChoiceBox.getValue()) {
            case "Title":  break;
            case "Author": books = bookService.findAllByAuthor(query); break; // TODO: 13/07/2020 analogicznie uzupelnij
            case "Genre":  books = bookService.findAllByGenre(query); break;
            case "Year": break;
        }

        ObservableList<Book> observableList = FXCollections.observableList(books);
        searchResultListView.setItems(observableList);
    }

    public void onAddBookButtonClick(MouseEvent mouseEvent) {
        String title = bookTitleTextField.getText();
        String author = bookAuthorTextField.getText();
        int year = Integer.parseInt(bookYearTextField.getText());
        Genre genre = bookService.findGenreByName(bookGenreChoiceBox.getValue());

        if (author.contains(" ")) {
            Book book = new Book(title, author, year, genre.getId(), true);
            bookService.save(book);

            String[] name = author.split(" ");
            authorService.save(new Author(name[0], name[1]));

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Success!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Author needs firstName and lastName!");
            alert.showAndWait();
        }
    }

    public void onFindButtonClick(MouseEvent mouseEvent) {
        String query = findBookToLendTextField.getText();
        Set<Book> books = new HashSet<>();

        books.addAll(bookService.findAllByAuthor(query));
        books.addAll(bookService.findAllByGenre(query));
        // TODO: 13/07/2020 dopiac reszte metod, ktore szukaja po poj. atrybutach

        ObservableList<Book> observableBooks = FXCollections.observableList(new ArrayList<>(books));
        bookToLendListView.setItems(observableBooks);
    }

    public void onExitButtonClick(MouseEvent mouseEvent) {
        System.exit(1);
    }
}
