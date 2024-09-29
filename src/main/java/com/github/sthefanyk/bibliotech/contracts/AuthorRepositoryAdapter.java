package com.github.sthefanyk.bibliotech.contracts;

import java.util.List;

import com.github.sthefanyk.bibliotech.models.Author;

public interface AuthorRepositoryAdapter {
    void create(Author author);
    void save(Author author);
    void delete(String id);
    Author findByid(String id);
    List<Author> listAll();
}
