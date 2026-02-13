package com.assessment.api.error;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleRuntime(RuntimeException ex) {
        ApiError error = new ApiError("RESOURCE_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(404).body(error);
    }
}
