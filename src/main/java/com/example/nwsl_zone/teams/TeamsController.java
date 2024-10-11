package com.example.nwsl_zone.teams;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teams")
public class TeamsController {

    private final TeamsService teamsService;

    @Autowired
    public TeamsController(TeamsService teamsService) {this.teamsService = teamsService;}

    @GetMapping
    public List<Teams> getAllTeams(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name
    ) {
        if (id != null) {
            return teamsService.getTeamsById(id);
        }
        else if (name != null) {
            return teamsService.getTeamsByName(name);
        }
        return teamsService.getTeams();
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<String> deleteTeam(@PathVariable Integer teamId) {
        teamsService.deleteTeam(teamId);
        return new ResponseEntity<>("Team deleted successfully.", HttpStatus.OK);
    }
}
