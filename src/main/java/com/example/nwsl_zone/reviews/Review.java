package com.example.nwsl_zone.reviews;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @Column(name="id", unique = true)
    private Integer id;

    private String name;
    private String score;
    private LocalDateTime date;
    private String comment;

    public Review() {
    }

    public Review(Integer id, String name, String score, LocalDateTime date, String comment) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.date = date;
        this.comment = comment;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
