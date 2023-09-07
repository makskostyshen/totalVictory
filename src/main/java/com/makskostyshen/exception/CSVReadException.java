package com.makskostyshen.exception;

public class CSVReadException extends RuntimeException {
    public CSVReadException(final Exception e) {
        super(e);
    }
}
