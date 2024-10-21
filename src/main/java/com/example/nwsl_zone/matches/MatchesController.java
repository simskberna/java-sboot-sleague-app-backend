package com.example.nwsl_zone.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Matches> getMatches(
            Pageable pageable,
            @RequestParam(required = false) Integer match_id,
            @RequestParam(required = false) Integer home_team_id,
            @RequestParam(required = false) String venue,
            @RequestParam(required = false) Boolean recent,
            @RequestParam(required = false) Boolean upcoming
    ) {
        if(match_id != null) {
            return matchesService.getMatchesByMatchId(match_id,pageable);
        }
        else if (recent != null && recent) {

            return matchesService.getRecentResults(pageable);
        }
        else if(home_team_id != null) {
            return matchesService.getMatchesByHomeTeamId(home_team_id,pageable);
        }
        else if(venue != null) {
            return matchesService.getMatchesByVenue(venue,pageable);
        }
        else if (upcoming != null && upcoming) {
            return matchesService.getUpcomingMatches(pageable);
        }
        return matchesService.getAllMatchesWithTeamNames(pageable);
    }
    @DeleteMapping("/{matchId}")
    public ResponseEntity<String> deleteMatch(@PathVariable Integer matchId) {
        matchesService.deleteMatch(matchId);
        return new ResponseEntity<>("Match deleted successfully.", HttpStatus.OK);
    }
}
