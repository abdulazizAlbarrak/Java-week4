package com.example.week4hw19.ControllerAdvice;

import com.example.week4hw19.ApiResponse.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> IllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
    }
}
