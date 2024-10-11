package com.example.nwsl_zone.teams;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamsService {
    private final TeamsRepository teamsRepository;

    @Autowired
    public TeamsService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    public List<Teams> getTeams(){return teamsRepository.findAll();}
    public List<Teams> getTeamsById(Integer id){
        return teamsRepository.findAll().stream()
                .filter(teams -> teams.getId().equals(id))
                .collect(Collectors.toList());
    }
    public List<Teams> getTeamsByName(String name){
        return teamsRepository.findAll().stream()
                .filter(teams -> teams.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteTeam(Integer id) {
        teamsRepository.deleteById(id);
    }
}
