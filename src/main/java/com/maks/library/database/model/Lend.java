package com.maks.library.database.model;

import com.maks.library.Librarian;
import com.maks.library.database.model.AbstractModel;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lend extends AbstractModel {
    private int memberId;
    private int bookId;
    private LocalDate date;
    private Librarian librarian;
    private LocalDate returnDate;
    private LocalDate actualReturnDate;
}
