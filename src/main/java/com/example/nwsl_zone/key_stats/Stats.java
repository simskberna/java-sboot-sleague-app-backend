package com.example.nwsl_zone.key_stats;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="key_stats")
public class Stats {
    @Id
    @Column(name="id",unique = true)
    private long id;

    private Integer total_matches;
    private Integer total_teams;
    private Integer total_players;
    private Date last_updated;

    public Stats() {
    }
    public Stats(long id) {
        this.id = id;
    }

    public Stats(long id, Integer total_matches, Integer total_teams, Integer total_players, Date last_updated) {
        this.id = id;
        this.total_matches = total_matches;
        this.total_teams = total_teams;
        this.total_players = total_players;
        this.last_updated = last_updated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getTotal_matches() {
        return total_matches;
    }

    public void setTotal_matches(Integer total_matches) {
        this.total_matches = total_matches;
    }

    public Integer getTotal_teams() {
        return total_teams;
    }

    public void setTotal_teams(Integer total_teams) {
        this.total_teams = total_teams;
    }

    public Integer getTotal_players() {
        return total_players;
    }

    public void setTotal_players(Integer total_players) {
        this.total_players = total_players;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }
}
