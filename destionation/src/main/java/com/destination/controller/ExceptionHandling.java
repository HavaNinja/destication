package com.destination.controller;

import com.destination.model.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@Slf4j
@RestControllerAdvice()
public class ExceptionHandling {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HttpResponse> runtimeException(final RuntimeException e) {
        return createHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    private ResponseEntity<HttpResponse> createHttpResponse(final HttpStatus httpStatus, final String message) {
        final HttpResponse httpResponse = new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase(), message, new Date());
        return new ResponseEntity<>(httpResponse, httpStatus);
    }

}
