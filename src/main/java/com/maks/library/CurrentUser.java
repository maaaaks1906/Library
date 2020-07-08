package com.maks.library;

import com.maks.library.database.model.User;

public class CurrentUser {
    private static CurrentUser INSTANCE = null;

    private User user;

    public static CurrentUser getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CurrentUser();
        }

        return INSTANCE;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
