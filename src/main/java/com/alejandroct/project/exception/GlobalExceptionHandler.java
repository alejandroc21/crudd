package com.alejandroct.project.exception;

import com.alejandroct.project.model.dto.ErrorResponse;
import static com.alejandroct.project.utils.ErrorCatalog.*;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException(){
        return new ErrorResponse.Builder()
                .code(PRODUCT_NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND)
                .message(PRODUCT_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        BindingResult result = ex.getBindingResult();
        return new ErrorResponse.Builder()
                .code(INVALID_REQUEST.getCode())
                .status(HttpStatus.BAD_REQUEST)
                .message(INVALID_REQUEST.getMessage())
                .detailMessage(result.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).toList())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleInternalServerError(Exception ex){
        return new ErrorResponse.Builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .detailMessage(Collections.singletonList(ex.getMessage()))
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
