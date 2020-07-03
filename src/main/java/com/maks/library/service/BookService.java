package com.maks.library.service;

import com.maks.library.database.model.Book;
import com.maks.library.database.model.Genre;
import com.maks.library.database.repository.BookRepository;
import com.maks.library.database.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private static BookService INSTANCE = null;

    private BookRepository bookRepository = BookRepository.getInstance();
    private GenreRepository genreRepository = GenreRepository.getInstance();

    public static BookService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookService();
        }

        return INSTANCE;
    }

    public List<Book> findAllByGenre(String genreName) {
        Genre genre = genreRepository.findByGenre(genreName)
                .orElseThrow(() -> new RuntimeException("Nie ma takiego gatunku"));

        return bookRepository.findAll().stream()
            .filter(b -> b.getGenreId() == genre.getId())
            .collect(Collectors.toList());
    }

}
