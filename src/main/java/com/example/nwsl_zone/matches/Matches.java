package com.example.nwsl_zone.matches;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Entity
@Table(name = "matches")
public class Matches {

    @Id
    @Column(name = "id",unique = true)
    private Integer id;

    private Integer home_team_id;
    private Integer away_team_id;
    private LocalDateTime match_date;
    private String score;
    private String status;

    public Matches() {
    }

    public Matches(Integer id, Integer home_team_id, Integer away_team_id, LocalDateTime match_date, String score, String status) {
        this.id = id;
        this.home_team_id = home_team_id;
        this.away_team_id = away_team_id;
        this.match_date = match_date;
        this.score = score;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHome_team_id() {
        return home_team_id;
    }

    public void setHome_team_id(Integer home_team_id) {
        this.home_team_id = home_team_id;
    }

    public Integer getAway_team_id() {
        return away_team_id;
    }

    public void setAway_team_id(Integer away_team_id) {
        this.away_team_id = away_team_id;
    }

    public LocalDateTime getMatch_date() {
        return match_date;
    }

    public void setMatch_date(LocalDateTime match_date) {
        this.match_date = match_date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}