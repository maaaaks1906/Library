package com.maks.library.database.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author extends AbstractModel {

    @CsvBindByName
    private String firstName;

    @CsvBindByName
    private String lastName;


}
