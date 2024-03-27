package com.Ms2d4.tp1.Error;

public class EnseignantNotFoundException extends Exception {
    public EnseignantNotFoundException() {
        super();
    }

    public EnseignantNotFoundException(String message) {
        super(message);
    }

    public EnseignantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnseignantNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EnseignantNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
