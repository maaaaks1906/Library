package com.maks.library.service;

import com.maks.library.WrongCredentialsException;
import com.maks.library.database.model.User;
import com.maks.library.database.repository.UserRepository;

import java.util.List;

public class UserService {
    private final static int USER_ROLE = 3;

    private UserRepository userRepository = UserRepository.getInstance();

    private static UserService INSTANCE = null;

    public static UserService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }

        return INSTANCE;
    }

    public User login(String login, String password) throws WrongCredentialsException {
        return userRepository.findByLoginAndPassword(login, password).orElseThrow(WrongCredentialsException::new);
    }

    public User register(String firstName, String lastName, String login, String password) {
        return userRepository.save(new User(firstName, lastName, login, password, USER_ROLE));
    }

    public boolean isLoginTaken(String login) {
        return userRepository.findByLogin(login).isPresent();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
