package com.spaceshufflebe.repositories;

import com.spaceshufflebe.models.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
