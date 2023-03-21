package com.ada.msmarkamodel.controller;

import com.ada.msmarkamodel.model.exception.ExceptionDto;
import com.ada.msmarkamodel.model.exception.ForbiddenException;
import com.ada.msmarkamodel.model.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ExceptionDto handleException(NotFoundException e) {
        return new ExceptionDto("NOT_FOUND", e.getMessage());
    }

    @ExceptionHandler(ForbiddenException.class)
    public ExceptionDto handleException(ForbiddenException e) {
        return new ExceptionDto("FORBIDDEN", e.getMessage());
    }
}