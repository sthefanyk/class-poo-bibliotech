package com.github.sthefanyk.bibliotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.sthefanyk.bibliotech.use_cases.book.FindByIdBookUseCase;
import com.github.sthefanyk.bibliotech.use_cases.book.SearchManyBooksUseCase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/page")
public class BookPageController {

    @Autowired
    FindByIdBookUseCase findByIdBookUseCase;

    @Autowired
    SearchManyBooksUseCase searchManyBooksUseCase;

    @GetMapping("/{id}")
    public String bookPage(@PathVariable String id, Model model) {
        try {
            var book = findByIdBookUseCase.execute(id);
            var bookcase = searchManyBooksUseCase.execute(1, 8, "");

            model.addAttribute("bookcase", bookcase);
            model.addAttribute("book", book);
            return "bookPage";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Book not found!");
            return "notFound";
        }
    }
    
    
}
