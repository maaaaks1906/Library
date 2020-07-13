package com.maks.library.service;

import com.maks.library.database.model.Author;
import com.maks.library.database.model.Book;
import com.maks.library.database.model.Genre;
import com.maks.library.database.repository.AuthorRepository;
import com.maks.library.database.repository.BookRepository;
import com.maks.library.database.repository.GenreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private static BookService INSTANCE = null;

    private AuthorRepository authorRepository = AuthorRepository.getInstance();
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
                .orElse(null);

        if (genre == null) {
            return new ArrayList<>();
        }

        return bookRepository.findAll().stream()
            .filter(b -> b.getGenreId() == genre.getId())
            .collect(Collectors.toList());
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findAllByAuthor(String authorFullName) {
        return bookRepository.findAll().stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(authorFullName))
                .collect(Collectors.toList());
    }

    public Genre findGenreByName(String name) {
        return genreRepository.findAll().stream()
                .filter(genre -> genre.getGenre().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new RuntimeException("Genre Not Found"));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Genre findGenreById(int genreId) {
        return genreRepository.findById(genreId).orElseThrow(() -> new RuntimeException("Genre Not Found"));
    }
}
