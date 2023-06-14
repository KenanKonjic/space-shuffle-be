package com.spaceshufflebe.services;


import com.spaceshufflebe.models.SimpleUser;
import com.spaceshufflebe.models.dtos.UserDto;
import com.spaceshufflebe.models.entities.UserEntity;
import com.spaceshufflebe.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

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

    public UserDto getUser(String username) {
        UserEntity entity = getEntity(username);
        return toDto(entity);
    }

    private UserEntity getEntity(String username) {
        Optional<UserEntity> userOptional = Optional.ofNullable(userRepository.findFirstByUsername(username));
        if (userOptional.isPresent()) {
            return userOptional.get();
        }

        throw new RuntimeException("User with username:" + username + " does not exist!");    }

    private static UserDto toDto(UserEntity user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setCar(user.getCar());
        dto.setRole(user.getRole());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        return dto;
    }
}
