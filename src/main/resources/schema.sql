CREATE TABLE IF NOT EXISTS authors (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    biography TEXT
);

CREATE TABLE IF NOT EXISTS books (
    id VARCHAR(255) PRIMARY KEY,
    isbn VARCHAR(14) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    publication_date DATE NOT NULL,
    author_id VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    pages INT NOT NULL,
    language VARCHAR(50) NOT NULL,
    cover_url VARCHAR(255) NOT NULL,
    tags VARCHAR(255),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);