package com.infoshare.test.controller;

import com.infoshare.test.dto.ActorDto;
import com.infoshare.test.dto.MovieDto;
import com.infoshare.test.model.*;
import com.infoshare.test.service.MovieInsertService;
import com.infoshare.test.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieService movieService;

    @MockBean
    private MovieInsertService movieInsertService;

    private final Fixtures fixtures = new Fixtures();

    @Test
    public void testGetMovieById() throws Exception {
        given(this.movieService.findById(1L)).willReturn(fixtures.godFatherMovie);

        this.mvc.perform(get("/movies/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

    }


    @Test
    public void testGetAllMovies() throws Exception {
        given(this.movieService.findAll()).willReturn(fixtures.allMovies);

        this.mvc.perform(get("/movies").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetActorsByMovieId() throws Exception {
        given(this.movieService.getActorsByMovie(5L)).willReturn(fixtures.allActors);

        this.mvc.perform(get("/movies/5/actors").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    private class Fixtures {

        private List<MovieDto> allMovies = getMovies();
        private MovieDto godFatherMovie = allMovies.get(0);
        private MovieDto spaceOdysseyMovie = allMovies.get(1);
        private Movie databaseMovie = getMovie();
        private List<ActorDto> allActors = getActors();

        private List<MovieDto> getMovies() {
            Director director = new Director();
            director.setFirstName("Francis");
            director.setLastName("Coppola");
            Rating rating = new Rating();
            rating.setScore(9);
            MovieDto movie = new MovieDto("3-598-21500-2", "The Godfather", 1972, Category.CRIME, director, rating, 175);
            movie.setId(1L);


            Director director1 = new Director();
            director1.setFirstName("Stanley");
            director1.setLastName("Kubrick");
            Rating rating1 = new Rating();
            rating1.setScore(8);
            MovieDto movie1 = new MovieDto("3-598-21560-6", " 2001: A Space Odyssey", 1968, Category.SCI_FI, director1, rating1, 149);
            movie1.setId(2L);

            return Stream.of(movie, movie1).collect(Collectors.toList());
        }

        private List<ActorDto> getActors(){
            ActorDto actor = new ActorDto();
            actor.setFirstName("James");
            actor.setLastName("Bond");

            ActorDto actor1 = new ActorDto();
            actor.setFirstName("James1");
            actor.setLastName("Bond1");

            return Stream.of(actor, actor1).collect(Collectors.toList());

        }
    }


        private Movie getMovie() {
            Actor actor = new Actor();
            actor.setFirstName("James");
            actor.setLastName("Bond");

            Director director = new Director();
            director.setFirstName("Francis");
            director.setLastName("Coppola");
            Rating rating = new Rating();
            rating.setScore(9);
            Movie movie = new Movie("3-598-21500-2", "The Godfather", 1972, Category.CRIME, director, rating, 175, new ArrayList<>());
            movie.setId(1L);
            return movie;
        }
}
