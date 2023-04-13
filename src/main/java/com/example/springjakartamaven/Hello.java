package com.example.springjakartamaven;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Data
public class Hello {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Size(min = 1, max = 10, message = "skills must have between 1 and 10 items")
    @UniqueElements
    private List<String> skills;

}
