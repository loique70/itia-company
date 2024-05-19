package com.itia.sitevitrine.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralKnowExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GeneralKnowExceptionHandler.class);

    @ExceptionHandler(GeneralKnowException.class)
    public ResponseEntity<ApiResponse<?>> handleGeneralKnowException(GeneralKnowException exception) {
        if (exception.getLogger() != null && exception.getLevel() != null) {

            switch (exception.getLevel()) {
                case TRACE:
                    exception.getLogger().trace(exception.getMessage());
                    break;
                case DEBUG:
                    exception.getLogger().debug(exception.getMessage());
                    break;
                case INFO:
                    exception.getLogger().info(exception.getMessage());
                    break;
                case WARN:
                    exception.getLogger().warn(exception.getMessage());
                    break;
                case ERROR:
                    exception.getLogger().error(exception.getMessage());
                    break;
                default:
                    exception.getLogger().info(exception.getMessage());
                    break;

            }
            return new ResponseEntity<>(
                    new ApiResponseForError(exception.getSystemError(), exception.getData()),
                    exception.httpCode);

        } else {
            return new ResponseEntity<>(new ApiResponseForError(exception.getSystemError(), exception.getData()),
                    exception.httpCode);
        }

    }

}
