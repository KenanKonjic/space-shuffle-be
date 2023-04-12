package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.SignupDto;
import com.spaceshufflebe.services.SignupService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/signup")
@RestController
public class SignupController {
    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping()
    public boolean createAccount(@RequestBody SignupDto signup) {
        return signupService.createAccount(signup);
    }

}
