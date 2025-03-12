package com.curso.ms.mscreditassessor.application.exception.model;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionMessage {

    private String path;
    private String message;
    private String method;
    private Integer statusCode;


    public ExceptionMessage(HttpServletRequest request, HttpStatus status, String message) {
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.statusCode = status.value();
        this.message = message;
    }
}
