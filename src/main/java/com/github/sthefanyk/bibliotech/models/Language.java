package com.github.sthefanyk.bibliotech.models;

public enum Language {
    PORTUGUESE("Português"),
    ENGLISH("English");

    private final String displayName;

    Language(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static Language fromString(String language) {
        try {
            String enumName = language.replace(" ", "_").toUpperCase();
            return Language.valueOf(enumName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid language: " + language);
        }
    }
}
