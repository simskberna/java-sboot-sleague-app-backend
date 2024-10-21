package com.example.nwsl_zone.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Integer> {
    void deleteById(Integer id);
    Optional<Review> findById(Integer id);
}
