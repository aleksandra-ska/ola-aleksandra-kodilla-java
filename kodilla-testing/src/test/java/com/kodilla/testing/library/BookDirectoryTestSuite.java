package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "Jon Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBookWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> thelistOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        assertEquals(4, thelistOfBooks.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 0; n <= booksQuantity; n++) {
            Book theBook = new Book("Title" + n, "Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void theListBooksWithConditionMoreThan20() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBookWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBookWithCondition("Zero books")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBookWithCondition("Forty books")).thenReturn(resultListOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("Zero books");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("Forty books");

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(16, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void theListBooksWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        //When
        List<Book> theListOfBook10 = bookLibrary.listBooksWithCondition("An");

        //Then
        assertEquals(0, theListOfBook10.size());
        verify(libraryDatabaseMock, times(0)).listBookWithCondition(anyString());
    }

    @Test
    void theListBooksWithConditionAnyBorrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary((libraryDatabaseMock));
        LibraryUser libraryUser = new LibraryUser("Tom", "Ford", "5484213215");
        List<Book> resultListOf0BorrowedBook = new ArrayList<Book>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOf0BorrowedBook);

        //When
        List<Book> theListOfBorrowed0 = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(resultListOf0BorrowedBook.size(), theListOfBorrowed0.size());
    }

    @Test
    void theListBooksWithCondition1Borrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Tom", "Ford", "5484213215");
        List<Book> resultListOf1BorrowedBook = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOf1BorrowedBook);

        //When
        List<Book> theListOfBorrowed1 = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(resultListOf1BorrowedBook.size(), theListOfBorrowed1.size());

    }

    @Test
    void theListBooksWithCondition5Borrowed() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary((libraryDatabaseMock));
        LibraryUser libraryUser = new LibraryUser("Tom", "Ford", "5484213215");
        List<Book> resultListOf5BorrowedBooks = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOf5BorrowedBooks);

        //When
        List<Book> theListOfBorrowed5 = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(resultListOf5BorrowedBooks.size(), theListOfBorrowed5.size());
    }
}