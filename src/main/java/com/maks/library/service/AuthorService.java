package com.maks.library.service;

import com.maks.library.database.model.Author;
import com.maks.library.database.repository.AuthorRepository;

public class AuthorService {
    private static AuthorService INSTANCE = null;

    private AuthorRepository authorRepository = AuthorRepository.getInstance();

    public static AuthorService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthorService();
        }

        return INSTANCE;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
