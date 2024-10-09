package com.example.nwsl_zone.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) Integer team_id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) Integer season_goals
    ) {

         if(name != null) {
            return playerService.getPlayersByName(name);
        }
        else if(position != null) {
            return playerService.getPlayersByPos(position);
        }
         else if(team_id != null) {
             return playerService.getPlayersByTeamIds(String.valueOf(team_id));
         }
         else if(season_goals != null) {
             return playerService.getPlayersBySeasonGoal(String.valueOf(season_goals));
         }
        else {
            return playerService.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatePlayer = playerService.updatePlayer(player);
        if(updatePlayer != null) {
            return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully.",HttpStatus.OK);
    }
}
