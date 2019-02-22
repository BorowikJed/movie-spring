package com.infoshare.test.service;

import com.infoshare.test.exceptions.ResourceNotFoundMyException;
import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.requests.MovieUpdateRequest;
import com.infoshare.test.validation.MovieValidator;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieValidator movieValidator;
    private final MovieRepository movieRepository;

    public MovieService(MovieValidator movieValidator, MovieRepository movieRepository) {
        this.movieValidator = movieValidator;
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundMyException("Failed to save a movie with an ID: " + id));
    }

    public Movie updateMovie(Long id, MovieUpdateRequest movieUpdateRequest){

        Movie movie = findById(id);
        movie.setTitle(movieUpdateRequest.getTitle());
        movie.setYear(movieUpdateRequest.getYear());
        return movieRepository.save(movie);
    }
}
