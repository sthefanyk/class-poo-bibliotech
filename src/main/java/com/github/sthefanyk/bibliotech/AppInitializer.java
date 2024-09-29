package com.github.sthefanyk.bibliotech;

import com.github.sthefanyk.bibliotech.controllers.BookController;
import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryAuthorRepository;
import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryBookRepository;
import com.github.sthefanyk.bibliotech.use_cases.book.CreateBookUseCase;
import com.github.sthefanyk.bibliotech.use_cases.book.ListAllBooksUseCase;

public class AppInitializer {
    
    private static InMemoryBookRepository bookRepository = new InMemoryBookRepository();
    private static InMemoryAuthorRepository authorRepository = new InMemoryAuthorRepository();

    public static BookController initialize() {
        CreateBookUseCase createBookUseCase = new CreateBookUseCase(bookRepository, authorRepository);
        ListAllBooksUseCase listAllBooksUseCase = new ListAllBooksUseCase(bookRepository);

        return new BookController(createBookUseCase, listAllBooksUseCase);
    }
}

