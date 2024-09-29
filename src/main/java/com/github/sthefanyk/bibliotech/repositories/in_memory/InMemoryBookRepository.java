package com.github.sthefanyk.bibliotech.repositories.in_memory;

import java.util.ArrayList;
import java.util.List;

import com.github.sthefanyk.bibliotech.contracts.BookRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Book;

public class InMemoryBookRepository implements BookRepositoryAdapter{
    private List<Book> books;

    public InMemoryBookRepository() {
        this.books = new ArrayList<>();
    }

    @Override
    public void create(Book book) {
        this.books.add(book);
    }

    @Override
    public void save(Book bookUpdated) {
        books.forEach(book -> {
            if (book.getId().equals(bookUpdated.getId())) {
                book = bookUpdated;
            }
        });
    }

    @Override
    public void delete(String id) {
        this.books.removeIf(book -> book.getId().toString().equals(id));
    }

    @Override
    public Book findByid(String id) {
        for (Book book : books) {
            if (book.getId().toString().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> listAll() {
        return books;
    }
}
