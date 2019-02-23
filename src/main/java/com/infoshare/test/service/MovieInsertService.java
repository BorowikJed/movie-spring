package com.infoshare.test.service;

import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.repository.MovieRepositoryOld;
import com.infoshare.test.requests.MovieRequest;
import com.infoshare.test.validation.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MovieInsertService {

    private final MovieValidator movieValidator;
    private final MovieIdGeneratorService movieIdGeneratorService;
    private final MovieRepositoryOld movieRepositoryOld;
    private final MovieRepository movieRepository;

    public MovieInsertService(MovieValidator movieValidator, MovieIdGeneratorService movieIdGeneratorService, MovieRepositoryOld movieRepositoryOld, MovieRepository movieRepository) {
        this.movieValidator = movieValidator;
        this.movieIdGeneratorService = movieIdGeneratorService;
        this.movieRepositoryOld = movieRepositoryOld;
        this.movieRepository = movieRepository;
    }


    public Movie addNewMovie(Movie movie) {
        //movie.setId(movieIdGeneratorService.generateId());
        //movieValidator.validateMovie(movie);
        return movieRepository.save(movie);
    }




}