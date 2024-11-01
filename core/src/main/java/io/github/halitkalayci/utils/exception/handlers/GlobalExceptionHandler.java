package io.github.halitkalayci.utils.exception.handlers;

import io.github.halitkalayci.utils.exception.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({BusinessException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleBusinessException(BusinessException e)
  {
    return "Core handler";
  }
}
