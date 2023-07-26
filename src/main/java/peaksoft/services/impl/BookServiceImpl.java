package peaksoft.services.impl;

import peaksoft.enitities.Book;
import peaksoft.repasitoris.BookRepasitory;
import peaksoft.repasitoris.BookRepo;
import peaksoft.services.BookService;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    BookRepo bookRepo = new BookRepasitory();
    @Override
    public String saveBook(Book book) {
        bookRepo.saveBook(book);
        return "Successfully saved";

    }

    @Override
    public void saveAllBooks(List<Book> books) {
       bookRepo.saveAllBooks(books);
    }

    @Override
    public List<Book> findAll() {
       return bookRepo.findAll();

    }

    @Override
    public Book updateBook(Long oldBookId, Book book) {
        return bookRepo.updateBook(oldBookId,book);

    }

    @Override
    public String deleteBook(Long bookId) {
        bookRepo.deleteBook(bookId);
        return bookId+" is deleted!";
    }

    @Override
    public Book findById(Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("book with id " + bookId + " not found!!!"));
        return book;
    }
}
