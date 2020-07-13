package com.maks.library;

import com.maks.library.database.model.*;
import com.maks.library.database.repository.*;

import java.util.UUID;

public class DemoDataGenerator {

    public static void generateDemoData() {
//        Library library = Library.getInstance();
//        generateUsers(library);

        generateRoles();
        generateUsers();
        generateBooks();
        generateAuthors();
        generateGenres();
    }

    private static void generateRoles() {
        RoleRepository roleRepository = RoleRepository.getInstance();

        roleRepository.deleteAll();
        roleRepository.save(new Role("ROLE_LIBRARIAN")); // id = 1
        roleRepository.save(new Role("ROLE_ADMIN")); // id = 2
        roleRepository.save(new Role("ROLE_USER")); // id = 3
    }

    private static void generateUsers() {
        UserRepository userRepository = UserRepository.getInstance();

        userRepository.deleteAll();
        userRepository.save(new User("Adam", "Kowalski", "a", "a", 2));
        userRepository.save(new User("Krzysiek", "Kowal", "b", "b", 3));
        userRepository.save(new User("Maks", "Kaczmarek", "c", "c", 3));
        userRepository.save(new User("Ola", "Sienkiewicz", "d", "d", 3));
        userRepository.save(new User("Wladek", "Bibliotekarz", "e", "e", 1));
    }

    private static void generateAuthors() {
        AuthorRepository authorRepository = AuthorRepository.getInstance();

        authorRepository.deleteAll();
        authorRepository.save(new Author("Adam", "Mickiewicz"));
        authorRepository.save(new Author("Marysia", "Starosta"));
        authorRepository.save(new Author("Andrzej", "Sapkowski"));
    }

    private static void generateGenres() {
        GenreRepository genreRepository = GenreRepository.getInstance();

        genreRepository.deleteAll();
        genreRepository.save(new Genre("EDUCATION")); // id 1
        genreRepository.save(new Genre("SCI-FI"));   //id 2
        genreRepository.save(new Genre("FANTASY"));   //id 3
    }

    private static void generateBooks() {
        BookRepository bookRepository = BookRepository.getInstance();

        bookRepository.deleteAll();
        bookRepository.save(new Book("ABC", "Lem", 1991, 1,true));
        bookRepository.save(new Book("ABC", "Lem", 1991, 1,true));
        bookRepository.save(new Book("ABC", "Lem", 1991, 1,true));
        bookRepository.save(new Book("Wiedzmin", "Sapkowski", 1989, 3,true));
        bookRepository.save(new Book("Wiedzmin", "Sapkowski", 1989, 3,true));
        bookRepository.save(new Book("Wiedzmin", "Sapkowski", 1989, 3,true));
        bookRepository.save(new Book("Dziady", "Mickiewicz", 1987, 2,true));
        bookRepository.save(new Book("Dziady", "Mickiewicz", 1987, 2,true));
        bookRepository.save(new Book("Dziady", "Mickiewicz", 1987, 2,true));
        bookRepository.save(new Book("Dziady", "Mickiewicz", 1987, 2,true));
        bookRepository.save(new Book("Dziady", "Mickiewicz", 1987, 2,true));
        bookRepository.save(new Book("Dziady", "Mickiewicz", 1987, 2,true));
    }


}
