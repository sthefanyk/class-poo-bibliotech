package com.github.sthefanyk.bibliotech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryAuthorRepository;
import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryBookRepository;
import com.github.sthefanyk.bibliotech.use_cases.book.CreateBookUseCase;
import com.github.sthefanyk.bibliotech.use_cases.book.ListAllBooksUseCase;

@Configuration
public class BookConfig {
    @Bean
    public CreateBookUseCase createBookUseCase(InMemoryBookRepository bookRepository, InMemoryAuthorRepository authorRepository) {
        return new CreateBookUseCase(bookRepository, authorRepository);
    }

    @Bean
    public ListAllBooksUseCase listAllBooksUseCase(InMemoryBookRepository bookRepository) {
        return new ListAllBooksUseCase(bookRepository);
    }
}
