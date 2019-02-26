package com.infoshare.test.dto.mapper;


import com.infoshare.test.dto.MovieDto;
import com.infoshare.test.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public static MovieDto map(Movie movie) {
        MovieDto dto = new MovieDto();

        dto.setId(movie.getId());
        dto.setIsbn(movie.getIsbn());
        dto.setTitle(movie.getTitle());
        dto.setYear(movie.getYear());
        dto.setCategory(movie.getCategory());
        dto.setDirector(movie.getDirector());
        dto.setRating(movie.getRating());
        dto.setLengthInMinutes(movie.getLengthInMinutes());

        return dto;
    }

}