package com.github.sthefanyk.bibliotech.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.github.sthefanyk.bibliotech.utils.DateUtils;

public class Book {
    private UUID id;
    private ISBN isbn;
    private String title;
    private String description;
    private LocalDate publicationDate;
    private Author author;
    private String publisher;
    private Integer pages;
    private List<Tag> tags;
    private Language language;
    private BookCoverUrl coverUrl;
    
    public Book(Optional<UUID> id, String isbn, String title, String description, String publicationDate, Author author,
            String publisher, Integer pages, List<String> tags, String language, String coverUrl) {
        this.id = id.orElse(UUID.randomUUID());
        this.isbn = new ISBN(isbn);
        this.title = title;
        this.description = description;
        this.publicationDate = DateUtils.stringToLocalDate(publicationDate);
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;

        this.tags = new ArrayList<>();
        for (String tagString : tags) {
            this.tags.add(Tag.fromString(tagString));
        }

        this.language = Language.fromString(language);

        this.coverUrl = new BookCoverUrl(coverUrl);
    }

    public UUID getId() {
        return id;
    }
    public ISBN getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public Author getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public Integer getPages() {
        return pages;
    }
    public Language getLanguage() {
        return language;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public BookCoverUrl getCoverUrl() {
        return coverUrl;
    }
}
