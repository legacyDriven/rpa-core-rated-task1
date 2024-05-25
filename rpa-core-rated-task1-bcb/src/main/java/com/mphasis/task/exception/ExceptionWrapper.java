package com.mphasis.task.exception;

public class ExceptionWrapper extends RuntimeException {

    // error message example with 1 parameter
    public ExceptionWrapper(String message) {
        super(message);
    }
    // error message example with 2 parameters
    public ExceptionWrapper(String message, Throwable cause) {
        super(message, cause);
    }

}
