package com.devsuperior.dscommerce.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dscommerce.dto.CustomError;
import com.devsuperior.dscommerce.services.exceptions.DataBaseException;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    Instant timestamp = Instant.now();
    Integer status = HttpStatus.NOT_FOUND.value();
    String err = e.getMessage();
    String path = request.getRequestURI();
    CustomError error = new CustomError(timestamp, status, err, path);

    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(DataBaseException.class)
  public ResponseEntity<CustomError> dataBase(DataBaseException e, HttpServletRequest request) {
    Instant timestamp = Instant.now();
    Integer status = HttpStatus.CONFLICT.value();
    String err = e.getMessage();
    String path = request.getRequestURI();
    CustomError error = new CustomError(timestamp, status, err, path);

    return ResponseEntity.status(status).body(error);
  }
}
