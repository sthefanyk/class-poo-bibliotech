package com.github.sthefanyk.bibliotech.use_cases.author;

import java.util.Optional;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Author;

public class CreateAuthorUseCase {
    private AuthorRepositoryAdapter repositoryAuthor;

    public CreateAuthorUseCase(AuthorRepositoryAdapter repositoryAuthor) {
        this.repositoryAuthor = repositoryAuthor;
    }

    public Author execute(String name, String biography) {
        Author author = new Author(Optional.empty(), name, biography);
        this.repositoryAuthor.create(author);
        return author;
    }
}
