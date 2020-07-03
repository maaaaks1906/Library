package com.maks.library.database.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role extends AbstractModel {

    @CsvBindByName
    private String name;
}
