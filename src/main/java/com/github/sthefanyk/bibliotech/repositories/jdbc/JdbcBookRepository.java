package com.github.sthefanyk.bibliotech.repositories.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.sthefanyk.bibliotech.contracts.BookRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Author;
import com.github.sthefanyk.bibliotech.models.Book;
import com.github.sthefanyk.bibliotech.models.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JdbcBookRepository implements BookRepositoryAdapter {

    private final JdbcTemplate jdbcTemplate;
    private final JdbcAuthorRepository jdbcAuthorRepository;

    public JdbcBookRepository(JdbcTemplate jdbcTemplate, JdbcAuthorRepository jdbcAuthorRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcAuthorRepository = jdbcAuthorRepository;
    }

    @Override
    public void create(Book book) {
        String tags = String.join(",", book.getTags().stream()
            .map(Tag::toString)
            .collect(Collectors.toList()));

        String sql = "INSERT INTO books (id, isbn, title, description, publication_date, author_id, publisher, pages, language, cover_url, tags) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(sql, book.getId().toString(), book.getIsbn().getCode(), book.getTitle(),
                book.getDescription(), book.getPublicationDate(), book.getAuthor().getId().toString(),
                book.getPublisher(), book.getPages(), book.getLanguage().toString(), book.getCoverUrl().toString(), tags);
    }

    @Override
    public void save(Book book) {
        String tags = String.join(",", book.getTags().stream()
            .map(Tag::toString)
            .collect(Collectors.toList()));

        String sql = "UPDATE books SET isbn = ?, title = ?, description = ?, publication_date = ?, author_id = ?, publisher = ?, pages = ?, language = ?, cover_url = ?, tags = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getIsbn().getCode(), book.getTitle(), book.getDescription(),
                book.getPublicationDate(), book.getAuthor().getId().toString(), book.getPublisher(),
                book.getPages(), book.getLanguage().toString(), book.getCoverUrl().toString(), tags, book.getId().toString());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Book findByid(String id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BookRowMapper(), id);
    }


    @Override
    public List<Book> listAll() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    private class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            UUID id = UUID.fromString(rs.getString("id"));
            String isbn = rs.getString("isbn");
            String title = rs.getString("title");
            String description = rs.getString("description");
            LocalDate publicationDate = rs.getDate("publication_date").toLocalDate();
            Author author = jdbcAuthorRepository.findByid(rs.getString("author_id"));
            String publisher = rs.getString("publisher");
            Integer pages = rs.getInt("pages");
            String coverUrl = rs.getString("cover_url");
            String language = rs.getString("language");
            
            String tagsString = rs.getString("tags");
            List<String> tags = tagsString != null ? Arrays.asList(tagsString.split(",")) : new ArrayList<>();


            return new Book(Optional.of(id), isbn, title, description, publicationDate.toString(), author, 
                    publisher, pages, tags, language, coverUrl);
        }
    }
}

