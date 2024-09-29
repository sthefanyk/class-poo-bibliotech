package com.github.sthefanyk.bibliotech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryAuthorRepository;
import com.github.sthefanyk.bibliotech.use_cases.author.CreateAuthorUseCase;
import com.github.sthefanyk.bibliotech.use_cases.author.ListAllAuthorsUseCase;

@Configuration
public class AuthorConfig {
    @Bean
    public CreateAuthorUseCase createAuthorUseCase(InMemoryAuthorRepository authorRepository) {
        return new CreateAuthorUseCase(authorRepository);
    }

    @Bean
    public ListAllAuthorsUseCase listAllAuthorsUseCase(InMemoryAuthorRepository authorRepository) {
        return new ListAllAuthorsUseCase(authorRepository);
    }
}
