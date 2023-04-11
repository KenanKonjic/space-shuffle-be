package com.spaceshufflebe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class SignupDto {
    private String name;
    private String surname;
    private String studId;
    private String email;
    private String password;
    private Boolean car;
}
