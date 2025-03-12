package com.curso.ms.mscreditassessor.application.exception.base;

public class InternalServerException extends RuntimeException {
  public InternalServerException(String message) {
    super(message);
  }
}
