package com.maks.library.database.repository;

import com.maks.library.database.model.Author;

import java.util.List;
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

    public List<Author> findAuthorByName(String name) {
        return findAll().stream().filter(author -> author.getLastName().equals(name)).collect(Collectors.toList());
    }

}
