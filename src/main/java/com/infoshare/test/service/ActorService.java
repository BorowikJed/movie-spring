package com.infoshare.test.service;

import com.infoshare.test.model.Actor;
import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.ActorRepository;
import com.infoshare.test.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//TODO: czy to zostawić czy nie?
public class ActorService {

    private final MovieService movieService;
    private final ActorRepository actorRepository;

    public ActorService(MovieService movieService, ActorRepository actorRepository) {
        this.movieService = movieService;
        this.actorRepository = actorRepository;
    }

//    public List<Actor> getActorsByMovie(Long movieId)
//    {
//        return actorRepository.findAllByMovies(movieService.findById(movieId));
//    }
//
//    public List<Actor> findActorsByFirstName(String firstName)
//    {
//        return actorRepository.findAllByFirstName(firstName);
//    }
}

//Description:
//
//        The dependencies of some of the beans in the application context form a cycle:
//
//        movieController defined in file [C:\Users\jkijo\Documents\INFOSHAREACAD\spring-gda1-project-1\target\classes\com\infoshare\test\controller\MovieController.class]
//        ┌─────┐
//        |  movieService defined in file [C:\Users\jkijo\Documents\INFOSHAREACAD\spring-gda1-project-1\target\classes\com\infoshare\test\service\MovieService.class]
//        ↑     ↓
//        |  actorService defined in file [C:\Users\jkijo\Documents\INFOSHAREACAD\spring-gda1-project-1\target\classes\com\infoshare\test\service\ActorService.class]
//        └─────┘