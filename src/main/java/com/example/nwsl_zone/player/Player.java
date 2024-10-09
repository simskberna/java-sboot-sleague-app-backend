package com.example.nwsl_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="players")
public class Player {
    @Id
    @Column(name="id",unique = true)
    private long id;

    private String name;
    private String position;
    private Integer team_id;
    private Integer season_goals;
    private Integer career_goals;
    private Integer assists;

    public Player() {
    }

    public Player(long id, String name, String position, Integer team_id, Integer season_goals, Integer career_goals, Integer assists) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.team_id = team_id;
        this.season_goals = season_goals;
        this.career_goals = career_goals;
        this.assists = assists;
    }

    public Player(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getSeason_goals() {
        return season_goals;
    }

    public void setSeason_goals(Integer season_goals) {
        this.season_goals = season_goals;
    }

    public Integer getCareer_goals() {
        return career_goals;
    }

    public void setCareer_goals(Integer career_goals) {
        this.career_goals = career_goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }
}
