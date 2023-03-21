package com.ada.msmarkamodel.model.exception;

public class ForbiddenException extends RuntimeException {
    private String code;

    public ForbiddenException(String message, String code) {
        super(message);
        this.code = code;
    }
}