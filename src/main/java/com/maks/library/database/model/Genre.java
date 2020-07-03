package com.maks.library.database.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Genre extends AbstractModel {

    @CsvBindByName
    private String genre;
}
