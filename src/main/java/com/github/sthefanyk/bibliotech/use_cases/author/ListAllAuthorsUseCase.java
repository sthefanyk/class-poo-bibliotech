package com.github.sthefanyk.bibliotech.use_cases.author;

import java.util.List;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Author;

public class ListAllAuthorsUseCase {
    private AuthorRepositoryAdapter repositoryAuthor;

    public ListAllAuthorsUseCase(AuthorRepositoryAdapter repositoryAuthor) {
        this.repositoryAuthor = repositoryAuthor;
    }

    public List<Author> execute() {
        return this.repositoryAuthor.listAll();
    }
}
