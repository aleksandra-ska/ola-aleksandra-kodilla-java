package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookLibrary {
    private  LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase){
        this.libraryDatabase = libraryDatabase;
    }
    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBookWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> rentBookList = new ArrayList<>();
        Book book1 = new Book("Book", "Author", 2000);
        rentBookList.add(book1);
        List<LibraryUser> usersList = new ArrayList<>();
        if(rentBookList.size() == 0 ) {
            System.out.println("User: " + usersList.get(usersList.size()) + " zero books");
        }else if (rentBookList.size() == 1) {
            System.out.println("User:" + usersList.get(usersList.size()) + " borrowed:" + rentBookList.get(usersList.size()));
        }else if (rentBookList.size() == 5) {
            System.out.println("User:" + usersList.get(usersList.size()) + " borrowed:" + rentBookList.get(usersList.size()));
        }
        return rentBookList;
    }
}
