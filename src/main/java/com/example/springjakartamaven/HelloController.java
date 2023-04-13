package com.example.springjakartamaven;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @PostMapping("/hello")
    public ResponseEntity<Hello> sayHello(@Valid @RequestBody Hello hello) {
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }
}
