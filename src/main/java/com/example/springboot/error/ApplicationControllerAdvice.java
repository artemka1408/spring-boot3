package com.example.springboot.error;

import com.example.springboot.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handle(final MethodArgumentNotValidException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.ARGUMENT_NOT_VALID);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponseDTO handle(final ForbiddenException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.ACCESS_DENIED);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handle(final PostNotFoundException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FOUND)
    public ErrorResponseDTO handle(final UserLoginAlreadyRegisteredException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.ALREADY_EXIST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handle(final UserLoginNotFoundException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handle(final UserNotFoundException e) {
        return new ErrorResponseDTO(ErrorResponseDTO.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseDTO handle(final UserPasswordNotMatchesException e) {
        return new ErrorResponseDTO("try_another");
    }

}
