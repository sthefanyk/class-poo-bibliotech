package com.github.sthefanyk.bibliotech.models;

public enum Language {
    PORTUGUESE,
    ENGLISH;

    public static Language fromString(String language) {
        try {
            String enumName = language.replace(" ", "_").toUpperCase();
            return Language.valueOf(enumName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid language: " + language);
        }
    }
}
