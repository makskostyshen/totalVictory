package com.makskostyshen.exception;

public class UpdateBackupException extends RuntimeException {
    public UpdateBackupException(final Exception e) {
        super(e);
    }
}
