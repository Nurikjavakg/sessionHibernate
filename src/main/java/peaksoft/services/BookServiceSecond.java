package peaksoft.services;

import peaksoft.enitities.Book;

import java.util.List;

public interface BookServiceSecond {
    String saveBook(Book book);
    void saveAllBooks(List<Book> books);
    List<Book> findAll();
    Book updateBook(Long oldBookId, Book book);
    String deleteBook(Long bookId);
    Book findById(Long bookId);
}
