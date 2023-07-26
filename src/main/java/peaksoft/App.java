package peaksoft;

import peaksoft.configration.DataBaseConnection;
import peaksoft.enitities.Book;
import peaksoft.services.BookService;
import peaksoft.services.BookServiceSecond;
import peaksoft.services.impl.BookServiceImpl;
import peaksoft.services.impl.BookServiceImplSecond;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // DataBaseConnection.createEntityManagerFactory();
        BookService bookService = new BookServiceImpl();
        BookServiceSecond bookServiceSecond = new BookServiceImplSecond();


        while (true) {
            System.out.println("""
                    Press to 1 book save""");
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> {
                    bookService.saveBook(new Book("Jamila", "Chyngyz Aitmatov", BigDecimal.valueOf(1000)));
                }
                case "2" -> {
                    bookService.saveAllBooks(List.of(
                            new Book("Kylym karytar bit kyn", "Chyngyz Aitmatov", BigDecimal.valueOf(1200)),
                            new Book("Jamila", "Chyngyz Aitmatov", BigDecimal.valueOf(1200)),
                            new Book("Kaidasyn", "Chyngyz Aitmatov", BigDecimal.valueOf(1200)),
                            new Book("Beyish jolu", "Chyngyz Aitmatov", BigDecimal.valueOf(1200)),
                            new Book("Kylym karytar bit kyn", "Chyngyz Aitmatov", BigDecimal.valueOf(1200)),
                            new Book("Kylym karytar bit kyn", "Chyngyz Aitmatov", BigDecimal.valueOf(1200))));
                }
                case "3" -> {
                    System.out.println(bookService.findAll());
                }
                case "4" -> {
                    System.out.println(bookService.updateBook(4L, new Book("If you dont first than you last", "Grant Cardone", BigDecimal.valueOf(4000.00))));
                }
                case "5" -> {
                    System.out.println(bookService.deleteBook(1L));
                }
                case "6" -> {
                    System.out.println("write id:");
                    try {
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println(bookService.findById(id));
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }


                }
                case "7" ->{
                    System.out.println(bookServiceSecond.findById(3L));
                }
                case "8" ->{
                    System.out.println(bookServiceSecond.updateBook(2L, new Book("Kapital", "Karl Maks", BigDecimal.valueOf(5000))));
                }
            }


        }
    }
}