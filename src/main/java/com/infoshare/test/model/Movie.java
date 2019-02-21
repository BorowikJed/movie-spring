package com.infoshare.test.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "movie_table")
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    private int year;
    private Category category;
    @ManyToOne
    private Director director;
    @ManyToOne
    private Rating rating;
    private int lengthInMinutes;

    public Movie() {
    }

    public Movie(Long id, String isbn, String title, int year, Category category, Director director, Rating rating, int lengthInMinutes) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.category = category;
        this.director = director;
        this.rating = rating;
        this.lengthInMinutes = lengthInMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
                lengthInMinutes == movie.lengthInMinutes &&
                Objects.equals(id, movie.id) &&
                Objects.equals(isbn, movie.isbn) &&
                Objects.equals(title, movie.title) &&
                category == movie.category &&
                Objects.equals(director, movie.director) &&
                Objects.equals(rating, movie.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, year, category, director, rating, lengthInMinutes);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", category=" + category +
                ", director=" + director +
                ", rating=" + rating +
                ", lengthInMinutes=" + lengthInMinutes +
                '}';
    }
}