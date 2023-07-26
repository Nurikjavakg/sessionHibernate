package peaksoft.repasitoris;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import peaksoft.configration.DataBaseConnection;
import peaksoft.enitities.Book;

import java.util.List;
import java.util.Optional;

public class BookRepasitorySecond implements BookRepoSecond{
    private final EntityManagerFactory entityManagerFactory = DataBaseConnection.createEntityManagerFactory();
    private final EntityManagerFactory sessionFactory = DataBaseConnection.createSessionFactory();
    BookRepo bookRepo = new BookRepasitory();
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
        EntityManager entityManager= DataBaseConnection.createSessionFactory().openSession();
        entityManager.getTransaction().begin();
        Book book1 = entityManager.find(Book.class, oldBookId);
        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        entityManager.getTransaction().commit();
        entityManager.close();
        return book1;
    }

    @Override
    public String deleteBook(Long bookId) {
        return null;
    }

    @Override
    public Book findById(Long bookId) {
        Session session = DataBaseConnection.createSessionFactory().openSession();
        session.beginTransaction();
        Book book = session.get(Book.class,bookId);
        session.getTransaction().commit();
        session.close();
        return book;
    }
}
