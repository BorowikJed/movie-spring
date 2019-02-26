package com.infoshare.test.controller;

import com.infoshare.test.dto.ActorDto;
import com.infoshare.test.dto.MovieDto;
import com.infoshare.test.dto.mapper.ActorMapper;
import com.infoshare.test.dto.mapper.MovieMapper;
import com.infoshare.test.model.Category;
import com.infoshare.test.requests.MovieRequest;
import com.infoshare.test.requests.MovieUpdateRequest;
import com.infoshare.test.service.ActorService;
import com.infoshare.test.service.MovieInsertService;
import com.infoshare.test.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<MovieDto> getAllMovies(){
        return movieService.findAll();
    }

    @GetMapping(value = "/{id}")
    public MovieDto getMovieById(@PathVariable Long id){
       return movieService.findById(id);
    }

    @GetMapping(value = "/{id}/actors")
    public List<ActorDto> getActorsByMovieId(@PathVariable Long id){
        return movieService.getActorsByMovie(id);
    }



    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieRequest movieRequest,
                                          @PathVariable Long id){
       return ResponseEntity.ok(MovieMapper.map(movieService.addNewMovie(movieRequest, id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieUpdateRequest movieUpdateRequest,
                                             @PathVariable Long id){
        return  ResponseEntity.ok(movieService.updateMovie(id, movieUpdateRequest));
    }

    @GetMapping("/search")
    public List<MovieDto> getAllMoviesFromCategory (@RequestParam Category category) {
        //Tu mamy listę, więc w sumie nie jest źle nie musimy sie bawic w ResponseEntity i statusy
        //po prostu pusta lista
        //ale jak DTO to dto i jechane z mapperem
        return  movieService.getMoviesFromCategory(category);
    }

//    @GetMapping(value = "/searchByName")
//    public List<MovieDto> getActorsByMovieId(@RequestParam String firstName){
//        return movieService.getMoviesByActorsName(firstName)
//                .stream()
//                .map(MovieMapper::map)
//                .collect(Collectors.toList());
//    }

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
