package com.example.springjakartamaven;

import com.example.springjakartamaven.model.HttpResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionHandling implements ErrorController {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponse<Void>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        return createHttpDataResponseWithFieldErrors(fieldErrors);
    }

    private ResponseEntity<HttpResponse<Void>> createHttpDataResponseWithFieldErrors(List<FieldError> fieldErrors) {
        HttpResponse<Void> httpResponse = new HttpResponse<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.isError(), "Validation error");
        for (org.springframework.validation.FieldError fieldError : fieldErrors) {
            httpResponse.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(httpResponse, HttpStatus.BAD_REQUEST);
    }
}
