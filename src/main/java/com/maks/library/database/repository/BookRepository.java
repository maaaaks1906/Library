package com.maks.library.database.repository;


import com.maks.library.database.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookRepository extends Repository<Book> {

    private static BookRepository INSTANCE = null;

    public BookRepository() {
        super("Books.csv", Book.class);
    }

    public static BookRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookRepository();
        }

        return INSTANCE;
    }

    public List<Book> findAllByTitle(String title) {
        return findAll().stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Book> findAllByYear(int year) {
        return findAll().stream()
                .filter(book -> book.getYear()== year)
                .collect(Collectors.toList());
    }


}
