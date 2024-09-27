package org.example.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Handle malformed JSON request
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("Malformed JSON request: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Handle HTTP request method not supported
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return new ResponseEntity<>("Method Not Supported: " + ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    // Handle missing request parameters
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingParams(MissingServletRequestParameterException ex) {
        String paramName = ex.getParameterName();
        return new ResponseEntity<>("Missing request parameter: " + paramName, HttpStatus.BAD_REQUEST);
    }

    // Handle any generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Internal Server Error");
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
