package com.example.nwsl_zone.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {
    void deleteById(Integer id);
    Optional<Teams> findById(Integer id);

    String findNameById(Integer id);
}
