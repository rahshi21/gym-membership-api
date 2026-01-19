package com.gm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
