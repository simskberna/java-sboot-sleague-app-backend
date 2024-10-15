package com.example.nwsl_zone.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/v1/matches")
public class MatchesController {

    private final MatchesService matchesService;

    @Autowired
    public MatchesController(MatchesService matchesService) {
        this.matchesService = matchesService;
    }

    @GetMapping
    public List<Matches> getMatches(
            @RequestParam(required = false) Integer match_id,
            @RequestParam(required = false) Integer home_team_id,
            @RequestParam(required = false) String venue,
            @RequestParam(required = false) Boolean recent,
            @RequestParam(required = false) Boolean upcoming
    ) {
        if(match_id != null) {
            return matchesService.getMatchesByMatchId(match_id);
        }
        else if (recent != null && recent) {

            return matchesService.getRecentResults();
        }
        else if(home_team_id != null) {
            return matchesService.getMatchesByHomeTeamId(home_team_id);
        }
        else if(venue != null) {
            return matchesService.getMatchesByVenue(venue);
        }
        else if (upcoming != null && upcoming) {
            return matchesService.getUpcomingMatches();
        }
        return matchesService.getAllMatchesWithTeamNames();
    }
    @DeleteMapping("/{matchId}")
    public ResponseEntity<String> deleteMatch(@PathVariable Integer matchId) {
        matchesService.deleteMatch(matchId);
        return new ResponseEntity<>("Match deleted successfully.", HttpStatus.OK);
    }
}
