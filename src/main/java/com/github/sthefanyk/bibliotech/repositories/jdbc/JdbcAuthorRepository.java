package com.github.sthefanyk.bibliotech.repositories.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.github.sthefanyk.bibliotech.contracts.AuthorRepositoryAdapter;
import com.github.sthefanyk.bibliotech.models.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JdbcAuthorRepository implements AuthorRepositoryAdapter {
    private JdbcTemplate jdbcTemplate;

    public JdbcAuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        String sql = "INSERT INTO authors (id, name, biography) VALUES (?, ?, ?)"; // Nome da tabela corrigido
        jdbcTemplate.update(sql, author.getId().toString(), author.getName(), author.getBiography());
    }

    @Override
    public void save(Author author) {
        String sql = "UPDATE authors SET name = ?, biography = ? WHERE id = ?";
        jdbcTemplate.update(sql, author.getName(), author.getBiography(), author.getId());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        jdbcTemplate.update(sql, UUID.fromString(id));
    }

    @Override
    public Author findByid(String id) {
        String sql = "SELECT * FROM authors WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new AuthorRowMapper(), id);
    }

    @Override
    public List<Author> listAll() {
        String sql = "SELECT * FROM authors";
        return jdbcTemplate.query(sql, new AuthorRowMapper());
    }

    private static class AuthorRowMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            UUID id = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            String biography = rs.getString("biography");
            return new Author(Optional.of(id), name, biography);
        }
    }

    
}

