package com.maks.library.database.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book extends AbstractModel {

    @CsvBindByName
    private String title;

    @CsvBindByName
    private String author;

    @CsvBindByName
    private int year;

    @CsvBindByName
    private int genreId;

    @CsvBindByName
    private boolean isAvailable;
}
