package com.maks.library.database.repository;

import com.maks.library.database.model.Author;
import com.maks.library.database.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthorRepository extends Repository<Author> {

    private static AuthorRepository INSTANCE = null;

    public AuthorRepository() {
        super("Authors.csv", Author.class);
    }

    public static AuthorRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthorRepository();
        }

        return INSTANCE;
    }

    public Optional<Author> findAuthorByNameAndSurname(String firstName, String lastName) {
        return findAll().stream().filter(a -> a.getFirstName().equalsIgnoreCase(firstName) && a.getLastName().equalsIgnoreCase(lastName)).findFirst();
    }

    public List<Author> findAuthorByName(String name) {
        return findAll().stream().filter(author -> author.getLastName().equals(name)).collect(Collectors.toList());
    }

    public List<Author> findAuthorByLastName (String lastName) {
        return findAll().stream()
                .filter(author -> author.getLastName().contains(lastName))
                .collect(Collectors.toList());
    }
}
