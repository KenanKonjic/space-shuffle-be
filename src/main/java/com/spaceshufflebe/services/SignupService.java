package com.spaceshufflebe.services;

import com.spaceshufflebe.models.SignupDto;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    public boolean validateSignup(SignupDto signup) {
        return signup.getName() != null && !signup.getName().isEmpty() &&
                signup.getSurname() != null && !signup.getSurname().isEmpty() &&
                signup.getEmail() != null && !signup.getEmail().isEmpty() &&
                signup.getStudId() != null && !signup.getStudId().isEmpty();
    }

    public boolean createAccount(SignupDto signup) {
        if (isEmailRegistered(signup.getEmail())) {
            return false;
        }
        if (validateSignup(signup)) {

        /*
        User newUser = new User();
        newUser.setUsername(getUsernameFromEmail(signup.getMail()));
        newUser.setName(signup.getName());
        newUser.setSurname(signup.getSurname());
        newUser.setMail(signup.getMail());
        newUser.setStudID(signup.getStudID());
        newUser.setCar(signup.isCar());
         */
        }
        return true;
    }

    private boolean isEmailRegistered(String email) {


        return true;
    }

    private String getUsernameFromEmail(String email) {
        int atIndex = email.indexOf('@');
        if (atIndex != -1) {
            return email.substring(0, atIndex);
        }
        return null;
    }
}
