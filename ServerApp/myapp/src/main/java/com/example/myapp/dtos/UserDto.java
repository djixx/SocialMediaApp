package com.example.myapp.dtos;

import com.example.myapp.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dateOfBirth;
    private String password;
    private String imageUrl;
    private Gender gender;
}
