package com.spaceshufflebe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LoginDto {
    private String username;
    private String password;
}
