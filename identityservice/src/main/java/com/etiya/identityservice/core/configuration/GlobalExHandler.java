package com.etiya.identityservice.core.configuration;

import jakarta.validation.ValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExHandler {
  @ExceptionHandler(ValidationException.class)
  public String Ex(ValidationException exception){
    return "Hata";
  }
}
