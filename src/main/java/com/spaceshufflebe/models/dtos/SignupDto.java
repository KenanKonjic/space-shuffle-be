package com.spaceshufflebe.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class SignupDto {
    private String name;
    private String surname;
    private Long Id;
    private String email;
    private String password;
    private Boolean car;
}
