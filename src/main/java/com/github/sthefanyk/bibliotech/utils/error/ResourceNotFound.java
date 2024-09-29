package com.github.sthefanyk.bibliotech.utils.error;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound() {
        super("Resource not found.");
    }

    public ResourceNotFound(String message) {
        super(message);
    }

    public ResourceNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFound(Throwable cause) {
        super(cause);
    }
}
