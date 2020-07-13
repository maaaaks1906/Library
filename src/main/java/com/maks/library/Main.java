package com.maks.library;

import com.maks.library.database.model.Book;
import com.maks.library.database.model.User;
import com.maks.library.database.repository.AuthorRepository;
import com.maks.library.database.repository.BookRepository;
import com.maks.library.database.repository.UserRepository;
import com.maks.library.service.BookService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    enum Menu {
        MAIN_MENU, LEND_BOOK_MENU, ADMIN_MENU, USER_MENU, FIND_BOOK
    }

    public static Scanner scanner = new Scanner(System.in);
    private static Menu menu = Menu.MAIN_MENU;
    private static Library library = Library.getInstance();

    private static Optional<User> currentUser = null;

    private static UserRepository userRepository = UserRepository.getInstance();
    private static BookRepository bookRepository = BookRepository.getInstance();

    private static BookService bookService = BookService.getInstance();

    public static void main(String[] args) {
        DemoDataGenerator.generateDemoData();

        while (true) {
            handleMenu();
        }
    }

    public static void handleMenu() {
        switch (menu) {
            case MAIN_MENU: handleMainMenu(); break;
            case ADMIN_MENU: handleAdminMenu(); break;
            case USER_MENU: handleUserMenu(); break;
            case LEND_BOOK_MENU: break;
            case FIND_BOOK: break;
        }
    }

    private static void handleMainMenu() {
        System.out.println("1. Zaloguj");
        System.out.println("2. Utworz konto");
        System.out.println("3. Zakoncz");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: handleLogin(); break;
            case 2: handleCreateNewMemberAccount(); break;
            case 3: exitLibrary(); break;
            default: System.out.println("Brak podanej opcji"); break;
        }
    }

    private static void exitLibrary() {
        System.exit(0);
    }

    private static void handleLogin() {
        System.out.println("Podaj login: ");
        String login = scanner.next();

        System.out.println("Podaj haslo: ");
        String password = scanner.next();

        userRepository.findByLoginAndPassword(login, password).ifPresent(user -> {
            currentUser = Optional.of(user);

            switch (user.getRoleId()) {
                case 2: menu = Menu.ADMIN_MENU; break;
                case 3: menu = Menu.USER_MENU; break;
                default: System.out.println("Bledna rola");
            }
        });
    }

    private static void handleCreateNewMemberAccount() {
        System.out.println("Podaj imie: ");
        String name = scanner.next();

        System.out.println("Podaj nazwisko: ");
        String lastName = scanner.next();

        System.out.println("Podaj login: ");
        String login = scanner.next();

        System.out.println("Podaj haslo: ");
        String password = scanner.next();

        if (userRepository.findByLogin(login).isPresent()) {
            System.out.println("BLAD");
            System.out.println("Login zajęty");
        } else {
            userRepository.save(new User(name, lastName, login, password, 3));

            System.out.println();
            System.out.println("+++++++++++++Konto utworzone+++++++++++++");
        }
    }

    private static void handleAdminMenu() {
        System.out.println("1. Znajdz ksiazke");
        System.out.println("2. Sprawdz wypozyczone ksiazki");
        System.out.println("3. Sprawdz zbior ksiazek");
        System.out.println("4. Dodaj ksiazke");
        System.out.println("5. Wyswietl liste uzytkownikow");
        System.out.println("6. Dodaj autora");
        System.out.println("7. Wyloguj");
        System.out.println("8. Zakoncz");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: handleFindBook(); break;
//            case 2: library.displayLendList(); break;
//            case 3: library.displayListOfBooks(); break;
//            case 4: handleAddBook(); break;
//            case 5: library.displayListOfMembers(); break;
//            case 6: addAuthor(); break;
//            case 7: logout(); break;
            case 8: exitLibrary(); break;
        }
    }

//    private static void logout() {
//        System.out.println("Wylogowano ");
//        menu = Menu.MAIN_MENU;
//    }
//
//    private static void handleAddBook() {
//        System.out.println("Podaj tytul: ");
//        String title = scanner.next();
//
//        System.out.println("Podaj rok: ");
//        int year = scanner.nextInt();
//
//        if (library.getAuthors().isEmpty()) {
//            System.out.println("Brak autorów nie mozna dodac ksiazki");
//        }else {
//            for (int i = 0; i < library.getAuthors().size(); i++) {
//                System.out.println((i + 1) + ". " + library.getAuthors().get(i).getName());
//            }
//            int choice = scanner.nextInt();
//            Author author = library.getAuthors().get(choice - 1);
//
//            library.printAllGenres();
//            choice = scanner.nextInt();
//            Book.Genre genre = Book.Genre.values()[choice - 1];
//
//            Book book = new Book.Builder()
//                    .bookTitle(title)
//                    .bookYear(year)
//                    .bookAuthor(author)
//                    .bookGenre(genre)
//                    .build();
////
////            library.addBook(book); todo wywalic metode
//            database.save(book);
//
//            System.out.println(book.getTitle()+ " dodano do biblioteki");
//        }
//    }
//
    private static void handleUserMenu() {
        System.out.println("1. Znajdz ksiazke");
        System.out.println("2. Wypożycz ksiazke");
        System.out.println("3. Zwroc ksiazke");
        System.out.println("4. Sprawdz zbior ksiazek");
        System.out.println("5. Sprawdz swoje wypozyczenia");
        System.out.println("6. Wyloguj");
        System.out.println("7. Zakoncz");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: handleFindBook(); break;
//            case 2: handleLendBook(); break;
//            case 3: handleReceiveBook(); break;
//            case 4: library.displayListOfBooks(); break;
//            case 5: library.displayMemberLendList(); break;
//            case 6: logout(); break;
            case 7: exitLibrary(); break;
        }
    }
//
//    private static void handleReceiveBook() {
//        Member member = library.getCurrentLoggedMember();
//        member.displayMemberLendList();
//
//        int choice = scanner.nextInt();
//        Lend lend = member.getLends().get(choice - 1);
//
//        lend.getBook().setAvailable(true);
//        lend.setActualReturnDate(LocalDate.now());
//        library.getLibraryBooks().add(lend.getBook());
//        member.getLends().removeIf(l -> l == lend);
//    }
//
//    private static void handleLendBook() {
//        Member member = library.getCurrentLoggedMember();
//
//        library.printAllBooks();
//
//        int choice = scanner.nextInt();
//        Book book = library.getBooks().get(choice - 1);
//
//        if (library.isBookAvailable(book)) {
//            if (library.isMembershipValid(member)) {
//                Lend lend = new Lend.Builder()
//                        .withMember(member)
//                        .lendingBook(book)
//                        .at(LocalDate.now())
//                        .withLibrarian(Library.systemLibrarian)
//                        .withReturnDate(LocalDate.now().plus(30, ChronoUnit.DAYS))
//                        .build();
//
//                library.getLends().add(lend);
//                member.getLends().add(lend);
//                library.getLibraryBooks().remove(book);
//
//            } else {
//                System.out.println(member.getFirstName() + " nie posiada czlonkostwa w bibliotece");
//            }
//        } else {
//            System.out.println("Brak ksiazki w bibliotece");
//        }
//    }
//
    private static void handleFindBook() {
        System.out.println("1. Znajdz po tytule");
        System.out.println("2. Znajdz po autorze");
        System.out.println("3. Znajdz po roku wydania");
        System.out.println("4. Znajdz po gatunku");
        System.out.println("5. Wróć");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1: handleFindAllBooksByTitle(); break;
            case 2: handleFindAllBooksByAuthor(); break; // null pointer
            case 3: handleFindAllBooksByYear(); break;
            case 4: handleFindAllBooksByGenre(); break;
            case 5: menu = Menu.USER_MENU; break;
        }
    }

    private static void handleFindAllBooksByGenre() {
        System.out.println("Podaj gatunek");
        String genre = scanner.next();

        System.out.println(bookService.findAllByGenre(genre));
    }

    private static void handleFindAllBooksByYear() {
        System.out.println("Podaj rok");
        int year = scanner.nextInt();

        if (BookRepository.getInstance().findAllByYear(year).isEmpty()) {
            System.out.println("Brak ksiazek wydanych w danym roku");
            handleFindBook();
        }
    }
//
//    public static void addAuthor() {
//        System.out.println("Podaj imie autora");
//        String name = scanner.next();
//
//        System.out.println("Podaj nazwisko autora");
//        String lastName = scanner.next();
//
//        Author author = new Author(name, lastName);
//        library.getAuthors().add(author);
//    }

    private static void handleFindAllBooksByAuthor() {
        System.out.println("Podaj nazwisko autora");
        String lastName = scanner.next();

        AuthorRepository authorRepository = AuthorRepository.getInstance();

        if (authorRepository.findAuthorByName(lastName).isEmpty()) {
            System.out.println("Brak autora o podanym nazwisku");
            handleFindBook();
        } else {
            System.out.println(authorRepository.findAuthorByLastName(lastName));
        }
    }

    private static void handleFindAllBooksByTitle() {
        System.out.println("Podaj tytul: ");
        String title = scanner.next();

        List<Book> books = bookRepository.findAllByTitle(title);
        if (!books.isEmpty()) {
            books.forEach(System.out::println);

        } else {
            System.out.println("Brak ksiazki w zbiorze");
            handleFindBook();
        }
    }
    
}
