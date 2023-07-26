package peaksoft.services;

import peaksoft.enitities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public String saveBook(Book book);

    void saveAllBooks(List<Book> books);

    List<Book> findAll();
    Book updateBook(Long oldBookId, Book book);
    String deleteBook(Long bookId);
    public Book findById(Long bookId);
}
