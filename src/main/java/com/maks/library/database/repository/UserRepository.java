package com.maks.library.database.repository;

import com.maks.library.database.model.User;

import java.util.Optional;

public class UserRepository extends Repository<User> {

    private static UserRepository INSTANCE = null;

    public UserRepository() {
        super("Users.csv", User.class);
    }

    public static UserRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }

        return INSTANCE;
    }

    public Optional<User> findByLogin(String login) {
        return findAll().stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }

    public Optional<User> findByLoginAndPassword(String login, String password) {
        return findAll().stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findFirst();
    }

}
