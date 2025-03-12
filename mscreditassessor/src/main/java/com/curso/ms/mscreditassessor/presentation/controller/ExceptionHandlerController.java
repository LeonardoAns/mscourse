package com.curso.ms.mscreditassessor.presentation.controller;

import com.curso.ms.mscreditassessor.application.exception.base.InternalServerException;
import com.curso.ms.mscreditassessor.application.exception.base.NotFoundException;
import com.curso.ms.mscreditassessor.application.exception.base.ServiceCommunicationException;
import com.curso.ms.mscreditassessor.application.exception.model.ExceptionMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessage> notFoundException(NotFoundException exception, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionMessage(request, HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ExceptionMessage> notFoundException(InternalServerException exception, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionMessage(request, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage()));
    }

}
