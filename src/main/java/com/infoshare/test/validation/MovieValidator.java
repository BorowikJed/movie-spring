package com.infoshare.test.validation;

import com.infoshare.test.model.Director;
import com.infoshare.test.model.Movie;
import com.infoshare.test.model.Rating;
import org.springframework.stereotype.Component;

import static com.infoshare.test.validation.Validate.*;

@Component
public class MovieValidator {

    public void validateMovie(Movie movie) {
        assertAllFieldsNotNull(movie);

        validateId(movie.getId());
        validateIsbn(movie.getIsbn());
        validateTitle(movie.getTitle());
        validateYear(movie.getYear());
        validateDirector(movie.getDirector());
        validateRating(movie.getRating());
        validateLength(movie.getLengthInMinutes());
    }

    private void validateId(Long id) {
        inclusiveBetween(1, 10, id);
    }

    private void validateIsbn(String isbn) {
        notBlank(isbn);
        isFalse(isbn.length() == 13, "ISBN number must be exactly 13 characters long.");
        isTrue(isbn.contains("-"), "ISBN number must contain at least one hyphen '-'.");
    }

    private void validateTitle(String title) {
        notBlank(title);
        inclusiveBetween(5, 10, title.length());

    }

    private void validateYear(int year) {
        inclusiveBetween(1900, 2019, year);
    }

    private void validateDirector(Director director) {
        notBlank(director.getFirstName());
        notBlank(director.getLastName());
    }

    private void validateRating(Rating rating) {
        inclusiveBetween(1, 10, rating.getScore());
    }

    private void validateLength(int lengthInMinutes) {
        inclusiveBetween(1, 600, lengthInMinutes);
    }

    private void assertAllFieldsNotNull(Movie movie) {
        notNull(movie);
        notNull(movie.getId());
        notNull(movie.getIsbn());
        notNull(movie.getTitle());
        notNull(movie.getCategory());
        notNull(movie.getDirector());
        notNull(movie.getRating());
    }
}