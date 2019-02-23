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

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/movies")
public class MovieController {

    //private final MovieRepository movieRepository;
    private final MovieInsertService movieInsertService;
    private final MovieService movieService;

    public MovieController(MovieInsertService movieInsertService, MovieService movieService) {
        this.movieInsertService = movieInsertService;
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Movie getMovieById(@PathVariable Long id){
       return movieService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
       return ResponseEntity.ok(movieInsertService.addNewMovie(movie));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody MovieUpdateRequest movieUpdateRequest,
                                             @PathVariable Long id){
        return  ResponseEntity.ok(movieService.updateMovie(id, movieUpdateRequest));
    }

    @GetMapping("/search")
    public List<Movie> getAllMoviesFromCategory (@RequestParam Category category) {
        //Tu mamy listę, więc w sumie nie jest źle nie musimy sie bawic w ResponseEntity i statusy
        //po prostu pusta lista
        return movieService.getMoviesFromCategory(category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMovieById(Long id) {
       if(movieService.exists(id)) {
           deleteMovieById(id);
           return ResponseEntity.noContent().build();
       }
       else
           return  ResponseEntity.notFound().build();

    }


}
