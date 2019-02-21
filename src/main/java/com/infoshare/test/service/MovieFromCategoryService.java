package com.infoshare.test.service;

import com.infoshare.test.model.Category;
import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.repository.MovieRepositoryOld;
import com.infoshare.test.validation.MovieValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieFromCategoryService {

    private final MovieValidator movieValidator;
    private final MovieRepository movieRepository;

    public MovieFromCategoryService(MovieValidator movieValidator, MovieRepository movieRepository) {
        this.movieValidator = movieValidator;
        this.movieRepository = movieRepository;
    }


    public List<Movie> getMoviesFromCategory(Category category){
        return movieRepository.findAllByCategory(category);
    }
}
