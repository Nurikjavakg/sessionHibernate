package peaksoft.services.impl;

import peaksoft.enitities.Book;
import peaksoft.repasitoris.BookRepasitorySecond;
import peaksoft.services.BookServiceSecond;

import java.util.List;

public class BookServiceImplSecond implements BookServiceSecond {
    BookRepasitorySecond bookRepasitorySecond = new BookRepasitorySecond();

    @Override
    public String saveBook(Book book) {
        return null;
    }

    @Override
    public void saveAllBooks(List<Book> books) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book updateBook(Long oldBookId, Book book) {
        return bookRepasitorySecond.updateBook(oldBookId,book);

    }

    @Override
    public String deleteBook(Long bookId) {
        return null;
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepasitorySecond.findById(bookId);

    }
}
