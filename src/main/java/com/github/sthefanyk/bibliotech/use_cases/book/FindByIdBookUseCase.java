package com.github.sthefanyk.bibliotech.use_cases.book;

import com.github.sthefanyk.bibliotech.contracts.BookRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Book;
import com.github.sthefanyk.bibliotech.utils.error.ResourceNotFound;

public class FindByIdBookUseCase {
    private BookRepositoryAdapter repositoryBook;

    public FindByIdBookUseCase(BookRepositoryAdapter repositoryBook) {
        this.repositoryBook = repositoryBook;
    }

    public Book execute(String id) {
        try {
            Book book = this.repositoryBook.findByid(id);
            return book;
            
        } catch (Exception e) {
            throw new ResourceNotFound("Book with this id not found.");
        }
    }
}
