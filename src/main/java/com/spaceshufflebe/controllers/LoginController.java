package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.LoginDto;
import com.spaceshufflebe.services.LoginService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping()
    public boolean createAccount(@RequestBody LoginDto login) {
        return loginService.validateLogin(login);
    }

}
