package com.example.springjakartamaven.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class HttpResponse<T> extends BaseResponse {

    public HttpResponse(Integer httpStatusCode, HttpStatus httpStatus, boolean error, @NonNull String message) {
        super(httpStatusCode, httpStatus, error);
        this.message = message;
    }

    @NonNull
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FieldError> fieldErrors = new ArrayList<>();

    public void addFieldError(String path, String message) {
        FieldError error = new FieldError(path, message);
        fieldErrors.add(error);
    }
}
