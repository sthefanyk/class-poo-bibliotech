package com.github.sthefanyk.bibliotech.contracts;

import java.util.List;

import com.github.sthefanyk.bibliotech.models.Book;

public interface BookRepositoryAdapter {
    void create(Book book);
    void save(Book book);
    void delete(String id);
    Book findByid(String id);
    List<Book> listAll();
    List<Book> searchMany(int page, int limit, String search);
}
