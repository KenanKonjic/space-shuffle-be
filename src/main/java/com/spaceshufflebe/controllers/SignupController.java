package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.SignupDto;
import com.spaceshufflebe.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/signup")
@RestController
public class SignupController {
    @Autowired
    private SignupService signupService;

    @PostMapping()
    public boolean createAccount(@RequestBody SignupDto signup) {
        return signupService.createAccount(signup);
    }

}
