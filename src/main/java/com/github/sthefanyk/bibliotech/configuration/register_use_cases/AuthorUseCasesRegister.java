package com.github.sthefanyk.bibliotech.configuration.register_use_cases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.use_cases.author.CreateAuthorUseCase;
import com.github.sthefanyk.bibliotech.use_cases.author.FindByIdAuthorUseCase;
import com.github.sthefanyk.bibliotech.use_cases.author.ListAllAuthorsUseCase;

@Configuration
public class AuthorUseCasesRegister {
    AuthorRepositoryAdapter authorRepository;

    public AuthorUseCasesRegister(AuthorRepositoryAdapter authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Bean
    public CreateAuthorUseCase createAuthorUseCase() {
        return new CreateAuthorUseCase(this.authorRepository);
    }

    @Bean
    public ListAllAuthorsUseCase listAllAuthorsUseCase() {
        return new ListAllAuthorsUseCase(this.authorRepository);
    }

    @Bean
    public FindByIdAuthorUseCase findByIdAuthorUseCase() {
        return new FindByIdAuthorUseCase(this.authorRepository);
    }
}
