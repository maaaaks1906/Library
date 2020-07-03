package com.maks.library.database.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends AbstractModel {

    @CsvBindByName(required = true)
    private String firstName;

    @CsvBindByName(required = true)
    private String lastName;

    @CsvBindByName(required = true)
    private String login;

    @CsvBindByName(required = true)
    private String password;

    @CsvBindByName(required = true)
    private int roleId;
}
