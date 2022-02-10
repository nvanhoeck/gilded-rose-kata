package com.gildedrose.exceptions;

/**
 * Since item should be untouched, validations are done on service level instead of model level
 * This would mean an error is thrown during item creation, and i'm not sure if that is the plan
 **/
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
