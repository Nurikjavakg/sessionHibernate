package peaksoft.repasitoris;

import peaksoft.enitities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepo {
     String saveBook(Book book);
     void saveAllBooks(List<Book> books);
     List<Book> findAll();
     Book updateBook(Long oldBookId, Book book);
     String deleteBook(Long bookId);
     public Optional<Book> findById(Long bookId);


}
