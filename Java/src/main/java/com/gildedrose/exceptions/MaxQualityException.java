package com.gildedrose.exceptions;

public class MaxQualityException extends ValidationException {

    public MaxQualityException(String message) {
        super(message);
    }

    public MaxQualityException(String message, Throwable cause) {
        super(message, cause);
    }
}
