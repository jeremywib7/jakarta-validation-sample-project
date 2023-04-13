package com.example.springjakartavalidation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {


    @PostMapping("/hello")
    public ResponseEntity<String> register(@Valid @RequestBody HelloRequest request) {
        return ResponseEntity.ok("Hello " + request.);
    }
}
