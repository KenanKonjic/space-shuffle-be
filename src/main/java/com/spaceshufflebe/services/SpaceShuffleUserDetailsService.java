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
public class SpaceShuffleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SpaceShuffleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String eMail) throws UsernameNotFoundException {
        UserEntity user = getFullUserByEmail(eMail);
        user = new UserEntity();
        user.setEmail(eMail);
        //$2a$12$6zdoF5KmZTdGH2/EkVav0.wQB.K.RxsKb6EfPeXUl0rNQ8xQaRUcS
        user.setPassword(userRepository.findFirstByEmail(eMail).getPassword());

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), Collections.emptyList());
    }

    public SimpleUser getUserByEmail(String eMail) {
        getFullUserByEmail(eMail); // user exists?
        return new SimpleUser(eMail);
    }

    private UserEntity getFullUserByEmail(String eMail) {
        return userRepository.findFirstByEmail(eMail);
    }
}
