package com.spaceshufflebe.services;

import com.spaceshufflebe.models.dtos.LoginDto;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateLogin(LoginDto login) {
        return login.getUsername() != null && !login.getUsername().isEmpty() &&
               login.getPassword() != null && !login.getPassword().isEmpty();
    }
}
