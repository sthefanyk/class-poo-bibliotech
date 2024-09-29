package com.github.sthefanyk.bibliotech.use_cases.book;

import java.util.List;
import java.util.Optional;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.contracts.BookRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Author;
import com.github.sthefanyk.bibliotech.models.Book;

public class CreateBookUseCase {
    private BookRepositoryAdapter repositoryBook;
    private AuthorRepositoryAdapter repositoryAuthor;

    public CreateBookUseCase(BookRepositoryAdapter repositoryBook, AuthorRepositoryAdapter repositoryAuthor) {
        this.repositoryBook = repositoryBook;
        this.repositoryAuthor = repositoryAuthor;
    }

    public Book execute(
        String isbn, String title, String description, String publicationDate, String authorId,
            String publisher, Integer pages, List<String> tags, String language, String coverUrl
    ) {
        Author author = this.repositoryAuthor.findByid(authorId);

        if (author instanceof Author) {
            Book book = new Book(Optional.empty(), isbn, title, description, publicationDate, author, publisher, pages, tags, language, coverUrl);
            this.repositoryBook.create(book);
            return book;
        }

        return null;
    }
}
