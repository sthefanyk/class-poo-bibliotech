package com.github.sthefanyk.bibliotech.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sthefanyk.bibliotech.use_cases.author.CreateAuthorUseCase;
import com.github.sthefanyk.bibliotech.use_cases.author.ListAllAuthorsUseCase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private CreateAuthorUseCase createAuthorUseCase;
    private ListAllAuthorsUseCase listAllAuthorsUseCase;

    public AuthorController(CreateAuthorUseCase createAuthorUseCase, ListAllAuthorsUseCase listAllAuthorsUseCase) {
        this.createAuthorUseCase = createAuthorUseCase;
        this.listAllAuthorsUseCase = listAllAuthorsUseCase;
    }

    /**
     * CreateRequest
     */
    public record CreateRequest(String name, String biography) {}

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody CreateRequest request) {

        try {
            var response = createAuthorUseCase.execute(request.name(), request.biography());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }        
    }

    @GetMapping()
    public ResponseEntity<Object> getMethodName() {
        try {
            var response = listAllAuthorsUseCase.execute();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } 
    }    
}
