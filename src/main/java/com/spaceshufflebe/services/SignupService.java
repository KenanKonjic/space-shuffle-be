package com.spaceshufflebe.services;

import com.spaceshufflebe.models.dtos.SignupDto;
import com.spaceshufflebe.models.entities.UserEntity;
import com.spaceshufflebe.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    private final UserRepository userRepository;
    public SignupService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean validateSignup(SignupDto signup) {
        return signup.getName() != null && !signup.getName().isEmpty() &&
                signup.getSurname() != null && !signup.getSurname().isEmpty() &&
                signup.getEmail() != null && !signup.getEmail().isEmpty();
    }

    public SignupDto createAccount(SignupDto signupDto) {
        UserEntity user = new UserEntity();
        user.setName(signupDto.getName());
        user.setSurname(signupDto.getSurname());
        user.setEmail(signupDto.getEmail());
        user.setPassword(signupDto.getPassword());
        user.setCar(signupDto.getCar());
        userRepository.save(user);

        signupDto.setId(user.getId());

        return signupDto;

//        if (isEmailRegistered(signupDto.getEmail())) {
//            return false;
//        }
//        if (validateSignup(signupDto)) {
//
//
//        User newUser = new User();
//        newUser.setUsername(getUsernameFromEmail(signup.getMail()));
//        newUser.setName(signup.getName());
//        newUser.setSurname(signup.getSurname());
//        newUser.setMail(signup.getMail());
//        newUser.setStudID(signup.getStudID());
//        newUser.setCar(signup.isCar());
//
//        }
//        return true;
    }
//
//    private boolean isEmailRegistered(String email) {
//
//
//        return true;
//    }

//    private String getUsernameFromEmail(String email) {
//        int atIndex = email.indexOf('@');
//        if (atIndex != -1) {
//            return email.substring(0, atIndex);
//        }
//        return null;
//    }
}
