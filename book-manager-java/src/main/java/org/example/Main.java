package org.example;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();

        // Tambah beberapa buku
        bookManager.addBook(new Book("Pemrograman", "Andi", 2026));
        bookManager.addBook(new Book("Basis Data", "Budi", 2021));
        bookManager.addBook(new Book("Java OOP", "Andi", 2022));

        System.out.println("📚 Daftar Semua Buku:");
        for (Book book : bookManager.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println("\n🔍 Cari buku penulis 'Andi':");
        for (Book book : bookManager.findBooksByAuthor("Andi")) {
            System.out.println(book);
        }

        System.out.println("\n❌ Hapus buku 'Basis Data':");
        boolean removed = bookManager.removeBook("Basis Data");
        System.out.println("Berhasil dihapus? " + removed);

        System.out.println("\n📚 Daftar Semua Buku (Setelah Hapus):");
        for (Book book : bookManager.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println("\nJumlah total buku: " + bookManager.getBookCount());}
}