package com.infoshare.test.requests;

import com.infoshare.test.model.Category;
import com.infoshare.test.model.Director;
import com.infoshare.test.model.Rating;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class MovieRequest {
    @Min(3)
    @NotEmpty
    private final String title;
    @Min(1900)
    @Max(2050)
    private final int year;
    private final Category category;
    private final Director director;
    private final Rating rating;
    @Min(50)
    @Max(270)
    private final int lengthInMinutes;

    public MovieRequest(String title, int year, Category category, Director director, Rating rating, int lengthInMinutes) {
        this.title = title;
        this.year = year;
        this.category = category;
        this.director = director;
        this.rating = rating;
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Category getCategory() {
        return category;
    }

    public Director getDirector() {
        return director;
    }

    public Rating getRating() {
        return rating;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
}
