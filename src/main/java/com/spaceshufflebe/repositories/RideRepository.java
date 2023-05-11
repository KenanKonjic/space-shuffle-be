package com.spaceshufflebe.repositories;

import com.spaceshufflebe.models.entities.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<RideEntity, Integer> {
}
