package com.maks.library;

import com.maks.library.database.model.*;
import com.maks.library.database.repository.BookRepository;
import com.maks.library.database.repository.UserRepository;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private static Library INSTANCE = new Library("Publiczna", "Krakowska12");

    private String name;
    private String address;
    private List<Book> libraryBooks;
    private List<Member> members;
    private List<Lend> lends;
    private List<Author> authors;
    private Member currentLoggedMember;

    private Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.libraryBooks = new ArrayList<>();
        this.members = new ArrayList<>();
        this.lends = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

    public static Library getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Library("Publiczna", "Krakowska12");
        }

        return INSTANCE;
    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public List<Book> getBooks() {
//        return libraryBooks;
//    }
//
//    public void setLibraryBooks(List<Book> libraryBooks) {
//        this.libraryBooks = libraryBooks;
//    }
//
//    public void setBooks(Book book) {
//    }
//
//    public List<Lend> getLends() {
//        return lends;
//    }
//
//    public void setLends(List<Lend> lends) {
//        this.lends = lends;
//    }
//
//    public List<Book> getLibraryBooks() {
//        return libraryBooks;
//    }
//
//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }
//
//    public List<Author> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(List<Author> authors) {
//        this.authors = authors;
//    }
//
//    public Member getCurrentLoggedMember() {
//        return currentLoggedMember;
//    }
//
//
//    public void setCurrentLoggedMember(Member currentLoggedMember) {
//        this.currentLoggedMember = currentLoggedMember;
//    }
//
//    public void addBook(Book book) {
//        libraryBooks.add(book);
//    }
//
////    public Optional<Lend> findLend(Book book, Member member) {
////        for (Lend lend : lends) {
////            if (lend.getBook().equals(book) && lend.getMember().equals(member) && lend.getActualReturnDate() == null) {
////                return Optional.of(lend);
////            }
////        }
////
////        return Optional.empty();
////    }
//
//    public boolean isBookAvailable(Book book) {
//        return libraryBooks.contains(book) && book.isAvailable();
//    }
//
//    public boolean isMembershipValid(Member member) {
//        return members.contains(member);
//    }
//
//    public void addMember(Member member) {
//        members.add(member);
//    }
//
    public Optional<User> loginUserWithCredentials(String login, String password) {
        UserRepository repo = UserRepository.getInstance();

        Optional<User> optionalUser = repo.findByLogin(login);
        if (optionalUser.isPresent()) {
            if (!optionalUser.get().getPassword().equals(password)) {
                return Optional.empty();
            }
        }

        return optionalUser;
    }
//
//    public void displayLendList() {
//        for (Lend l : lends) {
//            System.out.println(l);
//        }
//    }
//
//    public void displayListOfBooks () {
//        for (Book b : libraryBooks) {
//            System.out.println(b);
//        }
//    }
//
//    public void displayListOfMembers() {
//        for (Member m : members) {
//            System.out.println(m);
//        }
//    }
//
//    public void displayMemberLendList() {
//        // TODO: 01/06/2020
//    }
//
//    @Override
//    public String toString() {
//        return "Library{" +
//                "name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", libraryBooks=" + libraryBooks +
//                ", members=" + members +
//                ", lends=" + lends +
//                '}';
//    }
//
//    public List<Administrator> getAdministrators() {
//        return administrators;
//    }
//
    public List<Book> getAllBooksByTitle(String title) {
        return BookRepository.getInstance().findAllByTitle(title);
    }
//
//    public List<Book> getAllBooksByAuthor(String lastName) {
////        return authors.stream()
////                .filter(a -> a.getLastName().equals(lastName))
////                .map(Author::getAuthorBooks)
////                .flatMap(Collection::stream)
////                .collect(Collectors.toList());
//
//        return new ArrayList<>();
//    }
//
//    public List<Book> getAllBooksByYear(int year) {
//        return libraryBooks.stream()
//                .filter(y -> y.getYear() == year)
//                .collect(Collectors.toList());
//    }
//
//    public List<Book> getAllBookByGenre() {
//        return libraryBooks.stream()
////                .filter(g -> g.getGenre() == genre)
//                .collect(Collectors.toList());
//    }
//
//    public void printAllGenres() {
////        Book.Genre[] genres = Book.Genre.values();
////        for (int i = 0; i < genres.length; i++) {
////            System.out.println((i + 1) + ". " + genres[i]);
////        }
//    }
//
//    public void printAllBooks() {
//        for (int i = 0; i < libraryBooks.size(); i++) {
//            System.out.println((i + 1) + ". " + libraryBooks.get(i).getTitle());
//        }
//    }

}
