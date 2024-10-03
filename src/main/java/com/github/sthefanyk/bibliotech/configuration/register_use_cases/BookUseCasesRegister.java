package com.github.sthefanyk.bibliotech.configuration.register_use_cases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.contracts.BookRepositoryAdapter;
import com.github.sthefanyk.bibliotech.use_cases.book.CreateBookUseCase;
import com.github.sthefanyk.bibliotech.use_cases.book.FindByIdBookUseCase;
import com.github.sthefanyk.bibliotech.use_cases.book.ListAllBooksUseCase;
import com.github.sthefanyk.bibliotech.use_cases.book.SearchManyBooksUseCase;

@Configuration
public class BookUseCasesRegister {
    AuthorRepositoryAdapter authorRepository;
    BookRepositoryAdapter bookRepository;
    
    public BookUseCasesRegister(AuthorRepositoryAdapter authorRepository, BookRepositoryAdapter bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Bean
    public CreateBookUseCase createBookUseCase() {
        return new CreateBookUseCase(this.bookRepository, this.authorRepository);
    }

    @Bean
    public ListAllBooksUseCase listAllBooksUseCase() {
        return new ListAllBooksUseCase(this.bookRepository);
    }

    @Bean
    public FindByIdBookUseCase findByIdBookUseCase() {
        return new FindByIdBookUseCase(this.bookRepository);
    }

    @Bean
    public SearchManyBooksUseCase searchManyBooksUseCase() {
        return new SearchManyBooksUseCase(this.bookRepository);
    }

}
