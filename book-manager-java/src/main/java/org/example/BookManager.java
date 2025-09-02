package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private final List<Book> buku;

    public BookManager() {
        this.buku = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Buku tidak boleh kosong");
        }
        buku.add(book);
    }

    public boolean removeBook(String judul) {
        if (judul == null || judul.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        return buku.removeIf(b -> b.getJudul_Buku().equalsIgnoreCase(judul.trim()));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(buku);
    }

    public List<Book> findBooksByAuthor(String penulis) {
        if (penulis == null || penulis.trim().isEmpty()) {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
        return buku.stream()
                .filter(book -> book.getPenulis().equalsIgnoreCase(penulis.trim()))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByYear(int tahun) {
        if (tahun < 2000 || tahun > 2100) {
            throw new IllegalArgumentException("Tahun hanya bisa diisi dari tahun 2000 sampai 2100");
        }
        return buku.stream()
                .filter(book -> book.getTahun() == tahun)
                .collect(Collectors.toList());
    }

    public int getBookCount() {
        return buku.size();
    }

    public boolean containsBook(String judul) {
        if (judul == null || judul.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        return buku.stream()
                .anyMatch(book -> book.getJudul_Buku().equalsIgnoreCase(judul.trim()));
    }

    public void clearAllBooks() {
        buku.clear();
    }
}
