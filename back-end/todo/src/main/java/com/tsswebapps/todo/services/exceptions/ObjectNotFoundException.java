package com.tsswebapps.todo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -2538298621124563041L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
