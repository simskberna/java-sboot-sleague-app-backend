package com.example.nwsl_zone.matches;

import com.example.nwsl_zone.player.PlayerRepository;
import com.example.nwsl_zone.teams.TeamsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchesService {
    private final MatchesRepository matchesRepository;
    @Autowired
    public MatchesService(MatchesRepository matchesRepository) {
        this.matchesRepository = matchesRepository;
    }
    @Autowired
    private TeamsRepository teamsRepository;

    public Page<Matches> getMatches(Pageable pageable) {
        return matchesRepository.findAllMatchesWithTeams(pageable);
    }
    public Page<Matches> getMatchesByHomeTeamId(Integer home_team_id,Pageable pageable) {
        Page<Matches> matchesPage = matchesRepository.findAllMatchesWithTeams(pageable);
        List<Matches> filteredMatches = matchesPage.getContent().stream()
                .filter(matches -> matches.getHome_team_id().equals(home_team_id))
                .collect(Collectors.toList());
        return new PageImpl<>(filteredMatches, pageable, matchesPage.getTotalElements());
    }
    public Page<Matches> getMatchesByMatchId(Integer id,Pageable pageable) {
        Page<Matches> matchesPage = matchesRepository.findAllMatchesWithTeams(pageable);
        List<Matches> filteredMatches = matchesPage.getContent().stream()
                .filter(matches -> matches.getId().equals(id))
                .collect(Collectors.toList());
        return new PageImpl<>(filteredMatches, pageable, matchesPage.getTotalElements());
    }
    public Page<Matches> getMatchesByVenue(String venue,Pageable pageable) {
        Page<Matches> matchesPage = matchesRepository.findAllMatchesWithTeams(pageable);
        List<Matches> filteredMatches = matchesPage.getContent().stream()
                .filter(matches -> matches.getVenue().contains(venue))
                .collect(Collectors.toList());
        return new PageImpl<>(filteredMatches, pageable, matchesPage.getTotalElements());

    }
    public Page<Matches> getRecentResults(Pageable pageable) {
        LocalDateTime lastMonthStart = LocalDateTime.now().minusMonths(1);
        LocalDateTime lastMonthEnd = LocalDateTime.now();

        Page<Matches> matchesPage = matchesRepository.findAllMatchesWithTeams(pageable);
        List<Matches> filteredMatches = matchesPage.getContent().stream()
                .filter(matches -> {
                    LocalDateTime matchTime = matches.getMatch_date();
                    String matchStatus = matches.getStatus();
                    return (matchTime.isEqual(lastMonthStart) || matchTime.isAfter(lastMonthStart)) &&
                            (matchTime.isBefore(lastMonthEnd) || matchTime.isEqual(lastMonthEnd)) &&
                            matchStatus.equalsIgnoreCase("finished");
                })
                .collect(Collectors.toList());


        if (filteredMatches.isEmpty()) {
            List<Matches> allFinishedMatches = matchesPage.getContent().stream()
                    .filter(matches -> matches.getStatus().equalsIgnoreCase("finished"))
                    .collect(Collectors.toList());

            if (!allFinishedMatches.isEmpty()) {
                Collections.shuffle(allFinishedMatches);
                return new PageImpl<>(allFinishedMatches.stream()
                        .limit(5)
                        .collect(Collectors.toList()),pageable, allFinishedMatches.size());
            }
        }

        return new PageImpl<>(filteredMatches, pageable, matchesPage.getTotalElements());
    }
    public String getTeamNameById(Integer teamId) {
        return teamsRepository.findNameById(teamId);
    }
    public Page<Matches> getUpcomingMatches(Pageable pageable) {
        Page<Matches> matchesPage = matchesRepository.findAllMatchesWithTeams(pageable);
        List<Matches> filteredMatches = matchesPage.getContent().stream()
                .filter(matches -> matches.getStatus().contains("upcoming"))
                .collect(Collectors.toList());
        return new PageImpl<>(filteredMatches, pageable, matchesPage.getTotalElements());
    }
    public Page<Matches> getAllMatchesWithTeamNames(Pageable pageable) {
        return matchesRepository.findAllMatchesWithTeams(pageable);
    }

    @Transactional
    public void deleteMatch(Integer id) {
        matchesRepository.deleteById(id);
    }


}
