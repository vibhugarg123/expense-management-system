package com.slice.demoproject.aspects;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    List<String> errors = new ArrayList<String>();
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(
            error ->
                errors.add(
                    String.format("Field [%s] %s", error.getField(), error.getDefaultMessage())));

    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, errors.toString());
    problemDetail.setTitle(getTitleFromExceptionClass(ex));

    return new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST);
  }

  private String getTitleFromExceptionClass(Exception e) {
    return e.getClass()
        .getSimpleName()
        .replaceAll("(.)([A-Z])", "$1_$2")
        .toUpperCase(Locale.ROOT)
        .replace("_EXCEPTION", "");
  }
}
