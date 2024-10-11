package com.example.nwsl_zone.teams;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "teams")
public class Teams {
    @Id
    @Column(name = "id",unique = true)
    private Integer id;

    private String name;
    private String coach;
    private Integer championships;
    private LocalDateTime founded;

    public Teams() {
    }

    public Teams(Integer id) {
        this.id = id;
    }

    public Teams(Integer id, String name, String coach, Integer championships, LocalDateTime founded) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.championships = championships;
        this.founded = founded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Integer getChampionships() {
        return championships;
    }

    public void setChampionships(Integer championships) {
        this.championships = championships;
    }

    public LocalDateTime getFounded() {
        return founded;
    }

    public void setFounded(LocalDateTime founded) {
        this.founded = founded;
    }
}
