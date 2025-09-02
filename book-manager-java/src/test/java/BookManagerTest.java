import org.example.Book;
import org.example.BookManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
    }

    @Test
    @DisplayName("Test menambahkan buku")
    void testAddBook() {
        Book buku = new Book("Pemrograman", "Andi", 2020);
        bookManager.addBook(buku);
        assertEquals(1, bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test menghapus buku yang ada")
    void testRemoveExistingBook() {
        Book buku = new Book("Basis Data", "ErLangga", 2021);
        bookManager.addBook(buku);

        boolean removed = bookManager.removeBook("Basis Data");
        assertTrue(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    // Unit Test tambahan untuk menghapus buku yang tidak ada dalam list
    @Test
    @DisplayName("Test menghapus buku yang tidak ada")
    void testRemoveNonExistingBook() {
        boolean removed = bookManager.removeBook("Tidak Ada");
        assertFalse(removed);
    }

    // Unit Test tambahan untuk mencari buku berdasarkan penulis
    @Test
    @DisplayName("Test mencari buku berdasarkan author")
    void testFindBooksByAuthor() {
        Book buku = new Book("Java", "Dewo", 2025);
        bookManager.addBook(buku);

        List<Book> result = bookManager.findBooksByAuthor("Dewo");
        assertEquals(1, result.size());
        assertEquals("Java", result.get(0).getJudul_Buku());
    }

    // Unit Test tambahan untuk mendapatkan semua buku
    @Test
    @DisplayName("Test mendapatkan semua buku")
    void testGetAllBooks() {
        Book buku1 = new Book("Java", "Dewo", 2025);
        Book buku2 = new Book("Python", "Andi", 2024);

        bookManager.addBook(buku1);
        bookManager.addBook(buku2);

        List<Book> allBooks = bookManager.getAllBooks();
        assertEquals(2, allBooks.size());

    }
}
