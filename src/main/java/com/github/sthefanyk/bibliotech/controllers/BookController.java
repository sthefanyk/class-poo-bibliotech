package com.github.sthefanyk.bibliotech.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.contracts.BookRepositoryAdapter;
import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryAuthorRepository;
import com.github.sthefanyk.bibliotech.repositories.in_memory.InMemoryBookRepository;
import com.github.sthefanyk.bibliotech.use_cases.book.CreateBookUseCase;
import com.github.sthefanyk.bibliotech.use_cases.book.ListAllBooksUseCase;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/book")
public class BookController {

    private CreateBookUseCase createBookUseCase;
    private ListAllBooksUseCase listAllBooksUseCase;

    public BookController(CreateBookUseCase createBookUseCase, ListAllBooksUseCase listAllBooksUseCase) {
        this.createBookUseCase = createBookUseCase;
        this.listAllBooksUseCase = listAllBooksUseCase;
    }

    /**
     * CreateRequest
     */
    public record CreateRequest(String isbn, String title, String description, String publicationDate, String authorId,
            String publisher, Integer pages, List<String> tags, String language, String coverUrl) {}

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody CreateRequest request) {

        try {
            var response = createBookUseCase.execute(
                request.isbn(),
                request.title(),
                request.description(),
                request.publicationDate(),
                request.authorId(),
                request.publisher(),
                request.pages(),
                request.tags(),
                request.language(),
                request.coverUrl()
            );

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }        
    }

    @GetMapping()
    public ResponseEntity<Object> getMethodName() {
        try {
            var response = listAllBooksUseCase.execute();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } 
    }
}
