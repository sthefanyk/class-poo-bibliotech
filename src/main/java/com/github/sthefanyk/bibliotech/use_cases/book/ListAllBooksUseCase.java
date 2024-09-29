package com.github.sthefanyk.bibliotech.use_cases.book;

import java.util.List;

import com.github.sthefanyk.bibliotech.contracts.BookRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Book;

public class ListAllBooksUseCase {
    private BookRepositoryAdapter repositoryBook;

    public ListAllBooksUseCase(BookRepositoryAdapter repositoryBook) {
        this.repositoryBook = repositoryBook;
    }

    public List<Book> execute() {
        return this.repositoryBook.listAll();
    }
}
