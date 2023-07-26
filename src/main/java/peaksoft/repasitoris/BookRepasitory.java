package peaksoft.repasitoris;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.configration.DataBaseConnection;
import peaksoft.enitities.Book;

import java.util.List;
import java.util.Optional;

public class BookRepasitory implements BookRepo, AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = DataBaseConnection.createEntityManagerFactory();
    private final EntityManagerFactory sessionFactory = DataBaseConnection.createSessionFactory();
    @Override
    public String saveBook(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();

        return "book is successfully saved!";
    }

    @Override
    public void saveAllBooks(List<Book> books) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        books.forEach(entityManager::persist);
        entityManager.getTransaction().commit();;
        entityManager.close();

        }
        @Override
    public Optional<Book> findById(Long bookId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
               Book book = entityManager.find(Book.class, bookId);   //отработанный
//        Book book = entityManager.createQuery("""
//                        select b from  Book  b where id=:newId
//                        """, Book.class).setParameter("newId", bookId)
//                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return  Optional.ofNullable(book);//Optional.ofNullable(book);
    }

    @Override
    public List<Book> findAll() {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Book> resultList = entityManager.createQuery("""
                            
                    select b  from Book b
      
                """, Book.class).getResultList();
                    entityManager.getTransaction().commit();
            entityManager.close();
            return resultList;

    }

    @Override
    public Book updateBook(Long oldBookId, Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book oldBook = entityManager.createQuery("select b from Book b where id= :newBook",Book.class).setParameter("newBook",oldBookId).getSingleResult();
        oldBook.setName(book.getName());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setPrice(book.getPrice());
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public String deleteBook(Long bookId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.createQuery("select b from Book b where id= :newBook",Book.class).setParameter("newBook",bookId).getSingleResult();
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return bookId+" is successfully deleted!";
    }


    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
        sessionFactory.close();
    }
}

