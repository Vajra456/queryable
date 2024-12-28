package com.example.queryable.exception;

public class QueryableApplicationException extends Exception {
    public QueryableApplicationException(String message) {
        super(message);
    }

    public QueryableApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}