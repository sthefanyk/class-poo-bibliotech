package com.github.sthefanyk.bibliotech.use_cases.author;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Author;
import com.github.sthefanyk.bibliotech.utils.error.ResourceNotFound;

public class FindByIdAuthorUseCase {
    private AuthorRepositoryAdapter repositoryAuthor;

    public FindByIdAuthorUseCase(AuthorRepositoryAdapter repositoryAuthor) {
        this.repositoryAuthor = repositoryAuthor;
    }

    public Author execute(String id) {
        try {
            Author author = this.repositoryAuthor.findByid(id);
            return author;
            
        } catch (Exception e) {
            throw new ResourceNotFound("Author with this id not found.");
        }
    }
}
