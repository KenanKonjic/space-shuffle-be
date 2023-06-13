package com.spaceshufflebe.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Boolean car;
    private Boolean role;
}

