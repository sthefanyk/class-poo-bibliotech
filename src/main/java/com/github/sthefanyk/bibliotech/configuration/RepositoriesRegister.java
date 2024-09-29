package com.github.sthefanyk.bibliotech.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryAuthorRepository;
import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryBookRepository;
import com.github.sthefanyk.bibliotech.repositories.jdbc.JdbcAuthorRepository;
import com.github.sthefanyk.bibliotech.repositories.jdbc.JdbcBookRepository;

@Configuration
public class RepositoriesRegister {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public InMemoryAuthorRepository inMemoryAuthorRepository() {
        return new InMemoryAuthorRepository();
    }

    @Bean
    public InMemoryBookRepository inMemoryBookRepository() {
        return new InMemoryBookRepository();
    }

    @Bean
    @Primary
    public JdbcAuthorRepository jdbcAuthorRepository() {
        return new JdbcAuthorRepository(this.jdbcTemplate);
    }

    @Bean
    @Primary
    public JdbcBookRepository jdbcBookRepository(JdbcAuthorRepository jdbcAuthorRepository) {
        return new JdbcBookRepository(this.jdbcTemplate, jdbcAuthorRepository);
    }
    
}

