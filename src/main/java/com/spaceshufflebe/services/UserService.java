package com.spaceshufflebe.services;


import com.spaceshufflebe.models.SimpleUser;
import com.spaceshufflebe.models.entities.UserEntity;
import com.spaceshufflebe.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = getFullUserByUsername(username);
        user = new UserEntity();
        user.setUsername(username);
        //$2a$12$6zdoF5KmZTdGH2/EkVav0.wQB.K.RxsKb6EfPeXUl0rNQ8xQaRUcS
        user.setPassword(userRepository.findFirstByUsername(username).getPassword());

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), Collections.emptyList());
    }

    public SimpleUser getUserByUsername(String username) {
        getFullUserByUsername(username); // user exists?
        return new SimpleUser(username);
    }

    public UserEntity getFullUserByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }
}
