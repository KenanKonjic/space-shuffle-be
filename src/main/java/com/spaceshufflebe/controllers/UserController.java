package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.dtos.UserDto;
import com.spaceshufflebe.models.entities.UserEntity;
import com.spaceshufflebe.repositories.UserRepository;
import com.spaceshufflebe.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository; private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/id/{username}")
    public ResponseEntity<String> getUserId(@PathVariable String username){
        return ResponseEntity.ok(String.valueOf(userRepository.findFirstByUsername(username).getId()));
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<UserEntity> searchUserByUsername(@PathVariable String username) {
        try {
            UserEntity user = userRepository.findFirstByUsername(username);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            user.setPassword(null);

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        return userService.getUser(username);
    }
}
