package com.infoshare.test.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rating_table")
public class Rating {
    @OneToMany
    private List<Movie> movieList;
    @Id
    @GeneratedValue
    private Long id;
    private int score;

    public Rating() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return score == rating.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "score=" + score +
                '}';
    }
}