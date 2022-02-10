package com.gildedrose.exceptions;

public class MinQualityException extends ValidationException {

    public MinQualityException(String message) {
        super(message);
    }

    public MinQualityException(String message, Throwable cause) {
        super(message, cause);
    }
}
