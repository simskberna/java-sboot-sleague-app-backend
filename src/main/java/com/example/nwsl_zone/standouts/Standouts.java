package com.example.nwsl_zone.standouts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="standouts")
public class Standouts {
    @Id
    @Column(name="id",unique = true)
    private int id;

    private Integer total_goals;
    private Integer total_plays;
    private Integer total_top_players;
    private Integer total_leagues_covered;

    public Standouts() {
    }

    public Standouts(int id) {
        this.id = id;
    }

    public Standouts(int id, Integer total_goals, Integer total_plays, Integer total_top_players, Integer total_leagues_covered) {
        this.id = id;
        this.total_goals = total_goals;
        this.total_plays = total_plays;
        this.total_top_players = total_top_players;
        this.total_leagues_covered = total_leagues_covered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTotal_goals() {
        return total_goals;
    }

    public void setTotal_goals(Integer total_goals) {
        this.total_goals = total_goals;
    }

    public Integer getTotal_plays() {
        return total_plays;
    }

    public void setTotal_plays(Integer total_plays) {
        this.total_plays = total_plays;
    }

    public Integer getTotal_top_players() {
        return total_top_players;
    }

    public void setTotal_top_players(Integer total_top_players) {
        this.total_top_players = total_top_players;
    }

    public Integer getTotal_leagues_covered() {
        return total_leagues_covered;
    }

    public void setTotal_leagues_covered(Integer total_leagues_covered) {
        this.total_leagues_covered = total_leagues_covered;
    }
}
