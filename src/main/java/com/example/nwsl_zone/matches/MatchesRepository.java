package com.example.nwsl_zone.matches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, Integer> {

    void deleteById(Integer id);
    Optional<Matches> findById(Integer id);
}
