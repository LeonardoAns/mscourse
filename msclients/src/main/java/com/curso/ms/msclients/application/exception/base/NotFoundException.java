package com.curso.ms.msclients.application.exception.base;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
