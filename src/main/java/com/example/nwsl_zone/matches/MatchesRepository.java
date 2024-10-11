package com.example.nwsl_zone.matches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, Integer> {
    Optional<Matches> findById(Integer id);

    @Query("SELECT new com.example.nwsl_zone.matches.Matches(m.id, m.home_team_id, m.away_team_id, m.match_date, m.score, m.status, m.venue, th.name, ta.name) " +
            "FROM Matches m " +
            "JOIN Teams ta ON m.away_team_id = ta.id " +
            "JOIN Teams th ON m.home_team_id = th.id")
    List<Matches> findAllMatchesWithTeams();


}
