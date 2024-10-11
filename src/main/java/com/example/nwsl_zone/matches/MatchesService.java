package com.example.nwsl_zone.matches;

import com.example.nwsl_zone.player.PlayerRepository;
import com.example.nwsl_zone.teams.TeamsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchesService {
    private final MatchesRepository matchesRepository;
    @Autowired
    public MatchesService(MatchesRepository matchesRepository, PlayerRepository playerRepository) {
        this.matchesRepository = matchesRepository;
    }
    @Autowired
    private TeamsRepository teamsRepository;

    public List<Matches> getMatches() {
        return matchesRepository.findAll();
    }
    public List<Matches> getMatchesByHomeTeamId(Integer home_team_id) {
        return matchesRepository.findAll().stream()
                .filter(matches -> matches.getHome_team_id().equals(home_team_id))
                .collect(Collectors.toList());
    }
    public List<Matches> getMatchesByMatchId(Integer id) {
        return matchesRepository.findAll().stream()
                .filter(matches -> matches.getId().equals(id))
                .collect(Collectors.toList());
    }
    public List<Matches> getMatchesByVenue(String venue){
        return matchesRepository.findAll().stream()
                .filter(matches -> matches.getVenue().contains(venue))
                .collect(Collectors.toList());
    }
    public List<Matches> getRecentResults(LocalDateTime end_date,LocalDateTime start_date) {
        return matchesRepository.findAll().stream()
                .filter(matches -> {
                    LocalDateTime matchTime = matches.getMatch_date();
                    return (matchTime.isEqual(start_date) || matchTime.isAfter(start_date)) &&
                            (matchTime.isBefore(end_date) || matchTime.isEqual(end_date));
                })
                .collect(Collectors.toList());
    }
    public String getTeamNameById(Integer teamId) {
        return teamsRepository.findNameById(teamId);
    }
    public List<Matches> getAllMatchesWithTeamNames() {
        return matchesRepository.findAllMatchesWithTeams();
    }

    @Transactional
    public void deleteMatch(Integer id) {
        matchesRepository.deleteById(id);
    }


}
