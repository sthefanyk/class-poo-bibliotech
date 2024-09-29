package com.github.sthefanyk.bibliotech.models;

import java.util.Optional;
import java.util.UUID;

public class Author {
    private UUID id;
    private String name;
    private String biography;
    
    public Author(Optional<UUID> id, String name, String biography) {
        this.id = id.orElse(UUID.randomUUID());
        this.name = name;
        this.biography = biography;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBiography() {
        return biography;
    }
}
