package com.doksanbir.productcaching.exceptions;



import com.doksanbir.productcaching.exceptions.enums.ResponseEnum;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SimpleAppException.class)
    public ResponseEntity<ErrorResponse> springBootSimpleAppException(SimpleAppException e) {
        log.warn(e.getMessage(), e);
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build(), e.getHttpStatus());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn(e.getMessage(), e);
        return ErrorResponse.builder()
                .code(ResponseEnum.INVALID_PARAMETER.getStatus())
                .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                .build();
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.warn(e.getMessage(), e);
        return ErrorResponse.builder()
                .code(ResponseEnum.INVALID_PARAMETER.getStatus())
                .message(ResponseEnum.INVALID_PARAMETER.getMessage())
                .build();
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse constraintViolationException(ConstraintViolationException e) {
        log.warn(e.getMessage(), e);
        return ErrorResponse.builder()
                .code(ResponseEnum.INVALID_PARAMETER.getStatus())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse bindException(BindException e) {
        log.warn(e.getMessage(), e);
        return ErrorResponse.builder()
                .code(ResponseEnum.INVALID_PARAMETER.getStatus())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse invalidFormatException(InvalidFormatException e) {
        log.warn(e.getMessage(), e);
        return ErrorResponse.builder()
                .code(ResponseEnum.INVALID_PARAMETER.getStatus())
                .message(ResponseEnum.INVALID_PARAMETER.getMessage())
                .build();
    }

    @ExceptionHandler(value = JsonParseException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse jsonParseException(JsonParseException e) {
        log.warn(e.getMessage(), e);
        return ErrorResponse.builder()
                .code(ResponseEnum.INVALID_PARAMETER.getStatus())
                .message(ResponseEnum.INVALID_PARAMETER.getMessage())
                .build();
    }

    @ExceptionHandler(value = JsonMappingException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse jsonMappingException(JsonMappingException e) {
        log.warn(e.getMessage(), e);
        return ErrorResponse.builder()
                .code(ResponseEnum.INVALID_PARAMETER.getStatus())
                .message(ResponseEnum.INVALID_PARAMETER.getMessage())
                .build();
    }
}
