package com.example.nwsl_zone.matches;

import com.example.nwsl_zone.player.PlayerRepository;
import com.example.nwsl_zone.teams.TeamsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Collections;
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
        return matchesRepository.findAllMatchesWithTeams();
    }
    public List<Matches> getMatchesByHomeTeamId(Integer home_team_id) {
        return matchesRepository.findAllMatchesWithTeams().stream()
                .filter(matches -> matches.getHome_team_id().equals(home_team_id))
                .collect(Collectors.toList());
    }
    public List<Matches> getMatchesByMatchId(Integer id) {
        return matchesRepository.findAllMatchesWithTeams().stream()
                .filter(matches -> matches.getId().equals(id))
                .collect(Collectors.toList());
    }
    public List<Matches> getMatchesByVenue(String venue){
        return matchesRepository.findAllMatchesWithTeams().stream()
                .filter(matches -> matches.getVenue().contains(venue))
                .collect(Collectors.toList());
    }
    public List<Matches> getRecentResults() {
        LocalDateTime lastMonthStart = LocalDateTime.now().minusMonths(1);
        LocalDateTime lastMonthEnd = LocalDateTime.now();

        List<Matches> recentMatches = matchesRepository.findAllMatchesWithTeams().stream()
                .filter(matches -> {
                    LocalDateTime matchTime = matches.getMatch_date();
                    String matchStatus = matches.getStatus();
                    return (matchTime.isEqual(lastMonthStart) || matchTime.isAfter(lastMonthStart)) &&
                            (matchTime.isBefore(lastMonthEnd) || matchTime.isEqual(lastMonthEnd)) &&
                            matchStatus.equalsIgnoreCase("finished");
                })
                .collect(Collectors.toList());

        if (recentMatches.isEmpty()) {
            List<Matches> allFinishedMatches = matchesRepository.findAllMatchesWithTeams().stream()
                    .filter(matches -> matches.getStatus().equalsIgnoreCase("finished"))
                    .collect(Collectors.toList());

            if (!allFinishedMatches.isEmpty()) {
                Collections.shuffle(allFinishedMatches);
                return allFinishedMatches.stream()
                        .limit(5)
                        .collect(Collectors.toList());
            }
        }

        return recentMatches;
    }
    public String getTeamNameById(Integer teamId) {
        return teamsRepository.findNameById(teamId);
    }
    public List<Matches> getUpcomingMatches(){
        return matchesRepository.findAllMatchesWithTeams().stream()
                .filter(matches -> matches.getStatus().contains("upcoming"))
                .collect(Collectors.toList());
    }
    public List<Matches> getAllMatchesWithTeamNames() {
        return matchesRepository.findAllMatchesWithTeams();
    }

    @Transactional
    public void deleteMatch(Integer id) {
        matchesRepository.deleteById(id);
    }


}
