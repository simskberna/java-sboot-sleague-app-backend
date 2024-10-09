package com.example.nwsl_zone.key_stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {

    void deleteById(Integer id);
    Optional<Stats> findById(Integer id);
}
