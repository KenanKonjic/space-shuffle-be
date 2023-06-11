package com.spaceshufflebe.repositories;

import com.spaceshufflebe.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByUsername(String username);
}
