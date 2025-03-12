package com.curso.ms.mscreditassessor.application.exception.base;

import lombok.Getter;

public class ServiceCommunicationException extends RuntimeException {
    
    @Getter
    private Integer status;

    public ServiceCommunicationException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
