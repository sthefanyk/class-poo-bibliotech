package com.github.sthefanyk.bibliotech.models;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class BookCoverUrl {
    private URL url;

    public BookCoverUrl(String urlString) {
        try {
            URI uri = new URI(urlString);
            this.url = uri.toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL format: " + urlString, e);
        }
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url.toString();
    }
}


