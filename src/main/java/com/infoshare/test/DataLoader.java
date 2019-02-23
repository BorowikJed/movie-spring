package com.infoshare.test;

import com.infoshare.test.model.*;
import com.infoshare.test.repository.ActorRepository;
import com.infoshare.test.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    @Autowired
    public DataLoader(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    public void run(ApplicationArguments args) {
        getMovie1();
    }

    private void getMovie1() {
        Actor actor = new Actor();
        actor.setFirstName("James");
        actor.setLastName("Bond");
        actorRepository.save(actor);

        Director director = new Director();
        director.setFirstName("Francis");
        director.setLastName("Coppola");
        Rating rating = new Rating();
        rating.setScore(9);
        Movie movie = new Movie("3-598-21500-2", "The Godfather", 1972, Category.CRIME, director, rating, 175, new ArrayList<>());

        Director director1 = new Director();
        director1.setFirstName("Stanley");
        director1.setLastName("Kubrick");
        Rating rating1 = new Rating();
        rating1.setScore(8);
        Movie movie1 = new Movie("3-598-21560-6", " 2001: A Space Odyssey", 1968, Category.SCI_FI, director1, rating1, 149, new ArrayList<>());

        movieRepository.save(movie);
        movieRepository.save(movie1);

        movie.addActor(actor);
        movie1.addActor(actor);
        movieRepository.save(movie);
        movieRepository.save(movie1);

    }

}
