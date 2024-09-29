package com.github.sthefanyk.bibliotech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryAuthorRepository;
import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryBookRepository;

@Configuration
public class RepositoriesConfig {

    @Bean
    public InMemoryBookRepository bookRepository() {
        return new InMemoryBookRepository();
    }

    @Bean
    public InMemoryAuthorRepository authorRepository() {
        return new InMemoryAuthorRepository();
    }

    
}

