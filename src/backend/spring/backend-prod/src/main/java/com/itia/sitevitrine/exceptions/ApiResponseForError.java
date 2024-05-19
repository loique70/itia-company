package com.itia.sitevitrine.exceptions;

import org.slf4j.Logger;

import com.itia.sitevitrine.models.SystemError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponseForError<T> extends ApiResponse<T> {

    private String errorCode;
    private String errorMessageCode;
    private Logger logger;

    public ApiResponseForError(SystemError error, T data) {
        super(data);
        this.errorCode = error.getErrorCode();
        this.errorMessageCode = error.getErrorMessageCode();
        this.data = data;
    }

    public ApiResponseForError(Void printStackTrace, T data) {
        super(data);
    }

    public ApiResponseForError(T data) {
        super(data);
        this.data = data;
        GeneralException generalException = GeneralException.builder().build();
        if (data instanceof GeneralException) {
            generalException = (GeneralException) data;
            this.errorCode = generalException.getCode();
            this.errorMessageCode = generalException.getMessage();
        }
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessageCode() {
        return errorMessageCode;
    }

    public void setErrorMessageCode(String errorMessageCode) {
        this.errorMessageCode = errorMessageCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
