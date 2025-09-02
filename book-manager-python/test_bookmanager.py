import unittest
from book import Book
from book_manager import BookManager

class TestBookManager(unittest.TestCase):
    def setUp(self):
        self.book_manager = BookManager()

    def test_add_book(self):
        book = Book("Pemrograman", "Andi", 2020)
        self.book_manager.add_book(book)
        self.assertEqual(1, self.book_manager.get_book_count())

    def test_remove_existing_book(self):
        book = Book("Basis Data", "ErLangga", 2021)
        self.book_manager.add_book(book)

        removed = self.book_manager.remove_book("Basis Data")
        self.assertTrue(removed)
        self.assertEqual(0, self.book_manager.get_book_count())

    # Unit Test tambahan untuk menghapus buku yang tidak ada
    def test_remove_non_existing_book(self):
        removed = self.book_manager.remove_book("Tidak Ada")
        self.assertFalse(removed)

    # Unit Test tambahan untuk mencari buku berdasarkan penulis
    def test_find_books_by_author(self):
        book = Book("Java", "Dewo", 2025)
        self.book_manager.add_book(book)

        result = self.book_manager.find_books_by_author("Dewo")
        self.assertEqual(1, len(result))
        self.assertEqual("Java", result[0].title)

    # Unit Test tambahan untuk mendapatkan semua buku
    def test_get_all_books(self):
        book1 = Book("Java", "Dewo", 2025)
        book2 = Book("Python", "Andi", 2024)

        self.book_manager.add_book(book1)
        self.book_manager.add_book(book2)

        all_books = self.book_manager.get_all_books()
        self.assertEqual(2, len(all_books))


if __name__ == '__main__':
    unittest.main()
