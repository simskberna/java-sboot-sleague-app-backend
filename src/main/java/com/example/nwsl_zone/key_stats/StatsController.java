package com.example.nwsl_zone.key_stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stats")
public class StatsController {
    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }
    @GetMapping
    public List<Stats> getStats(
            @RequestParam(required = false) Long id
    ) {
        if(id != null){
            return statsService.getStatsById(id);
        }else{
            return statsService.getStats();
        }
    }

    @DeleteMapping("/{statId}")
    public ResponseEntity<String> deleteStat(@PathVariable Long statId) {
        statsService.deleteStat(Math.toIntExact(statId));
        return new ResponseEntity<>("Statistic deleted successfully.", HttpStatus.OK);
    }

}
