package com.example.nwsl_zone.standouts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StandoutsRepository extends JpaRepository<Standouts, Long> {
    void deleteById(Integer id);
    Optional<Standouts> findById(Integer id);
}
