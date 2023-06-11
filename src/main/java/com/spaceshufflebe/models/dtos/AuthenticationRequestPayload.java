package com.spaceshufflebe.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestPayload {
    private String name;
    private String surname;
    private String username;
    private String password;
    private Boolean car;
    private Boolean role;
}
