package com.maks.library.database.repository;

import com.maks.library.database.model.Role;

public class RoleRepository extends Repository<Role> {

    private static RoleRepository INSTANCE = null;

    public RoleRepository() {
        super("Roles.csv", Role.class);
    }

    public static RoleRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RoleRepository();
        }

        return INSTANCE;
    }

}
