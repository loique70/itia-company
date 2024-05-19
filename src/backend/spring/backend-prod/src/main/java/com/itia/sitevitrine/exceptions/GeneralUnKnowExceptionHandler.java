package com.itia.sitevitrine.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralUnKnowExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleUnknowException(Exception exception) {

        return new ResponseEntity<>(new ApiResponseForError(exception),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
