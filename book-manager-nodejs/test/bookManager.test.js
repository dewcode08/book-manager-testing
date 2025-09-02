const Book = require("../book");
const BookManager = require("../BookManager");

describe("BookManager", () => {
  let bookManager;

  beforeEach(() => {
    bookManager = new BookManager();
  });

  test("Test menambahkan buku", () => {
    const book = new Book("Test Book", "Test Author", 2023);
    bookManager.addBook(book);
    expect(bookManager.getBookCount()).toBe(1);
  });

  test("Test menambahkan null (invalid)", () => {
    expect(() => bookManager.addBook(null)).toThrow();
  });

  test("Test menghapus buku yang ada", () => {
    const book = new Book("To Remove", "Author", 2023);
    bookManager.addBook(book);

    const removed = bookManager.removeBook("To Remove");
    expect(removed).toBe(true);
    expect(bookManager.getBookCount()).toBe(0);
  });

  test("Test menghapus buku yang tidak ada", () => {
    const removed = bookManager.removeBook("Not Exist");
    expect(removed).toBe(false);
  });

  test("Test mencari buku berdasarkan author", () => {
    const book1 = new Book("Book A", "Author X", 2022);
    const book2 = new Book("Book B", "Author Y", 2023);
    const book3 = new Book("Book C", "Author X", 2021);
    bookManager.addBook(book1);
    bookManager.addBook(book2);
    bookManager.addBook(book3);

    const results = bookManager.findBooksByAuthor("Author X");
    expect(results.length).toBe(2);
    expect(results).toContain(book1);
    expect(results).toContain(book3);
  });

  test("Test mencari buku berdasarkan tahun", () => {
    const book1 = new Book("Book A", "Author X", 2020);
    const book2 = new Book("Book B", "Author Y", 2021);
    bookManager.addBook(book1);
    bookManager.addBook(book2);

    const results = bookManager.findBooksByYear(2020);
    expect(results.length).toBe(1);
    expect(results[0]).toBe(book1);
  });

  test("Test mendapatkan semua buku", () => {
    const book1 = new Book("Book A", "Author X", 2022);
    const book2 = new Book("Book B", "Author Y", 2023);
    bookManager.addBook(book1);
    bookManager.addBook(book2);

    const allBooks = bookManager.getAllBooks();
    expect(allBooks.length).toBe(2);
    expect(allBooks).toContain(book1);
    expect(allBooks).toContain(book2);
  });

  test("Test getBookCount setelah tambah dan hapus", () => {
    const book1 = new Book("Book A", "Author X", 2022);
    const book2 = new Book("Book B", "Author Y", 2023);
    bookManager.addBook(book1);
    bookManager.addBook(book2);

    expect(bookManager.getBookCount()).toBe(2);

    bookManager.removeBook("Book A");
    expect(bookManager.getBookCount()).toBe(1);
  });

  test("Test containsBook jika buku ada", () => {
    const book = new Book("Exist Book", "Author Z", 2023);
    bookManager.addBook(book);

    expect(bookManager.containsBook("Exist Book")).toBe(true);
  });

  test("Test containsBook jika buku tidak ada", () => {
    expect(bookManager.containsBook("Ghost Book")).toBe(false);
  });

  test("Test clearAllBooks menghapus semua buku", () => {
    const book1 = new Book("Book A", "Author X", 2022);
    const book2 = new Book("Book B", "Author Y", 2023);
    bookManager.addBook(book1);
    bookManager.addBook(book2);

    bookManager.clearAllBooks();
    expect(bookManager.getBookCount()).toBe(0);
    expect(bookManager.getAllBooks().length).toBe(0);
  });
});

describe("Book class", () => {
  test("Test equals() membandingkan dua buku yang sama", () => {
    const book1 = new Book("Title", "Author", 2023);
    const book2 = new Book("Title", "Author", 2023);
    expect(book1.equals(book2)).toBe(true);
  });

  test("Test equals() membandingkan dua buku yang beda", () => {
    const book1 = new Book("Title", "Author", 2023);
    const book2 = new Book("Other", "Author", 2023);
    expect(book1.equals(book2)).toBe(false);
  });

  test("Test toString() mengembalikan format string", () => {
    const book = new Book("My Book", "John Doe", 2022);
    expect(book.toString()).toBe("My Book by John Doe (2022)");
  });
});
