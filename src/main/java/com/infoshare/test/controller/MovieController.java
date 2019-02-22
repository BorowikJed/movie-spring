package com.infoshare.test.controller;

import com.infoshare.test.model.Category;
import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.requests.MovieUpdateRequest;
import com.infoshare.test.service.MovieInsertService;
import com.infoshare.test.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;
    private final MovieInsertService movieInsertService;
    private final MovieService movieService;

    public MovieController(MovieRepository movieRepository, MovieInsertService movieInsertService, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieInsertService = movieInsertService;
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return movieRepository.findById(id)
                .map(movie -> ResponseEntity.ok(movie))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
       return movieInsertService.addNewMovie(movie);
    }

    @PutMapping(value = "/{id}")
    public Movie updateMovie(@RequestBody MovieUpdateRequest movieUpdateRequest,
                                             @PathVariable Long id){

        return  movieService.updateMovie(id, movieUpdateRequest);
    }

    @GetMapping("/search")
    public List<Movie> getAllMoviesFromCategory (@RequestParam Category category)
    {
        //Tu mamy listę, więc w sumie nie jest źle nie musimy sie bawic w ResponseEntity i statusy
        //po prostu pusta lista
        return movieRepository.findAllByCategory(category);
    }


}
