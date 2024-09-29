package com.github.sthefanyk.bibliotech.repositories.in_memory;

import java.util.ArrayList;
import java.util.List;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Author;

public class InMemoryAuthorRepository implements AuthorRepositoryAdapter{

    private List<Author> authors;

    public InMemoryAuthorRepository() {
        this.authors = new ArrayList<>();
    }

    @Override
    public void create(Author author) {
        this.authors.add(author);
    }

    @Override
    public void save(Author authorUpdated) {
        authors.forEach(author -> {
            if (author.getId().equals(authorUpdated.getId())) {
                author = authorUpdated;
            }
        });
    }

    @Override
    public void delete(String id) {
        this.authors.removeIf(author -> author.getId().toString().equals(id));
    }

    @Override
    public Author findByid(String id) {
        for (Author author : authors) {
            if (author.getId().toString().equals(id)) {
                return author;
            }
        }
        return null;
    }

    @Override
    public List<Author> listAll() {
        return authors;
    }
    
}
