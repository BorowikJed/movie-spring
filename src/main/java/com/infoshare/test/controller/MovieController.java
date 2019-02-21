package com.infoshare.test.controller;

import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.service.MovieInsertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;
    private final MovieInsertService movieInsertService;

    public MovieController(MovieRepository movieRepository, MovieInsertService movieInsertService) {
        this.movieRepository = movieRepository;
        this.movieInsertService = movieInsertService;
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
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id){
        return new ResponseEntity<Movie>(HttpStatus.OK);
    }



}
