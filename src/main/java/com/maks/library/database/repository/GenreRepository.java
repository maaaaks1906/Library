package com.maks.library.database.repository;

import com.maks.library.database.model.Genre;

import java.util.Optional;

public class GenreRepository extends Repository <Genre> {

    private static GenreRepository INSTANCE = null;

    public GenreRepository() {
        super("Genres.csv", Genre.class);
    }

    public static GenreRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GenreRepository();
        }

        return INSTANCE;
    }


    public Optional<Genre> findByGenre(String genre) {
        return findAll().stream()
                .filter(g -> g.getGenre().equalsIgnoreCase(genre))
                .findFirst();
    }

}
