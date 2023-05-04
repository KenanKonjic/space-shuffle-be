package com.spaceshufflebe.repositories;

import com.spaceshufflebe.models.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
}
