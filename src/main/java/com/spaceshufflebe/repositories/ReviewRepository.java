package com.spaceshufflebe.repositories;

import com.spaceshufflebe.models.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
