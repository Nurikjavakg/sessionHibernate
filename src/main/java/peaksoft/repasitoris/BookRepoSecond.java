package peaksoft.repasitoris;

import peaksoft.enitities.Book;

import java.util.List;

public interface BookRepoSecond {
    String saveBook(Book book);
    void saveAllBooks(List<Book> books);
    List<Book> findAll();
    Book updateBook(Long oldBookId, Book book);
    String deleteBook(Long bookId);
    Book findById(Long bookId);


}
