package com.doksanbir.productcaching.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SimpleAppException extends RuntimeException{
    private final String code;
    private final HttpStatus httpStatus;

    public SimpleAppException(String message, String code, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
