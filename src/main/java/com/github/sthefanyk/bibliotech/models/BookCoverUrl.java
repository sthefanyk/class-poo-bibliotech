package com.github.sthefanyk.bibliotech.models;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class BookCoverUrl {
    private URL url;

    // Constructor that uses URI for validation and conversion to URL
    public BookCoverUrl(String urlString) {
        try {
            URI uri = new URI(urlString);  // Creates a URI instance
            this.url = uri.toURL();        // Converts URI to URL
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL format: " + urlString, e);
        }
    }

    // Getter to retrieve the URL
    public URL getUrl() {
        return url;
    }

    // Override toString to return the URL as a string
    @Override
    public String toString() {
        return url.toString();
    }
}


