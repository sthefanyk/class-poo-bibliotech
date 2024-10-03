package com.github.sthefanyk.bibliotech.use_cases.book;

import java.util.List;

import com.github.sthefanyk.bibliotech.contracts.BookRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Book;

public class SearchManyBooksUseCase {
    private BookRepositoryAdapter bookRepository;

    public SearchManyBooksUseCase(BookRepositoryAdapter bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public List<Book> execute(int page, int limit, String search) {
        return this.bookRepository.searchMany(page, limit, search);
    }
}
