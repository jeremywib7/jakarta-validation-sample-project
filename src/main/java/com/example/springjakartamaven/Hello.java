package com.example.springjakartamaven;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;
import java.util.List;

@Data
public class Hello {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Pattern(regexp="\\+62\\d{9,12}", message="Invalid phone number format. Please use +62 followed by 9-12 digits.")
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Past(message="birth date must be in the past")
    private Date birthDate;

    @Size(min = 1, max = 10, message = "skills must have between 1 and 10 items")
    @UniqueElements
    private List<String> skills;

}
