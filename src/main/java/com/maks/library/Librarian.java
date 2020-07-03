package com.maks.library;

import com.maks.library.database.model.Lend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Librarian {

//    private String name;
//    private Library library;
//
//    public Librarian(String name, Library library) {
//        this.name = name;
//        this.library = library;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void addNewMember(Member member) {
//        library.getMembers().add(member);
//    }
//
//    public void lendABook() {
//
//        // TODO: 2020-05-09 jesli zalogowany jest bibliotekarz i do niego przychodzi ktos to to nie zadziala
//        Member member = library.getCurrentLoggedMember();                                      //todo tak rozwiazalem wypozyczanie ksiazki ZROBIONE
//
//        Book book = lendBook();                                       // TODO: 07/05/2020 zrob tak zeby pytalo jaka ksiazke chcesz
//                                                                                // wypozyczyc
//                                                                                // 1. Znajdz tytul etc
//        if (library.isBookAvailable(book)) {
//            if (library.isMembershipValid(member)) {
//                Lend lend = new Lend(member, book, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS), this);
//                library.getLends().add(lend);
//                member.getLends().add(lend);
//                library.getLibraryBooks().remove(book);
//            } else {
//                System.out.println(member.getFirstName() + " nie posiada czlonkostwa w bibliotece");
//            }
//        } else {
//            System.out.println("Brak ksiazki w bibliotece");
//            lendABook();
//        }
//    }
//
//    private Book lendBook() {                             // TODO: 2020-05-09 metoda mówi o wyswietlaniu, a robi co innego ZROBIONE
//        if (!library.getBooks().isEmpty()) {
//            System.out.println("Wybierz tytul ksiazki do wypozyczenia");
//            for (int i = 0; i < library.getBooks().size(); i++) {
//                System.out.println((i + 1) + ". " + library.getBooks().get(i).getTitle());
//            }
//
//            int choice = Main.scanner.nextInt();
//            return library.getBooks().get(choice - 1);
//        }
//
//        return null;
//    }





//    public void receiveBook() {
//
//        Member member = getMember();
//
//        for (int i = 0; i < member.getLends().size(); i++) {
//            System.out.println((i + 1) + ". " + member.getLends().get(i).getBook());
//        }
//        int choice = scanner.nextInt();
//        member.getLends().get(choice - 1);
//
//        Optional<Lend> lend = library.findLend(book, member); // TODO: 07/05/2020  przyjmowanie ksiazki z listy wypozyczen
//        if (lend.isPresent()) {
//            book.setAvailable(true);
//            library.getLibraryBooks().add(book);
//            lend.get().setActualReturnDate(LocalDate.now());
//        } else {
//            System.out.println("Wypozyczenie nie istnieje");
//        }
//    }

}