package com.infoshare.test.service;

import com.infoshare.test.dto.ActorDto;
import com.infoshare.test.dto.MovieDto;
import com.infoshare.test.dto.mapper.ActorMapper;
import com.infoshare.test.dto.mapper.MovieMapper;
import com.infoshare.test.exceptions.ResourceNotFoundMyException;
import com.infoshare.test.model.Actor;
import com.infoshare.test.model.Category;
import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.ActorRepository;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.requests.MovieRequest;
import com.infoshare.test.requests.MovieUpdateRequest;
import com.infoshare.test.validation.MovieValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieValidator movieValidator;
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public MovieService(MovieValidator movieValidator, MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieValidator = movieValidator;
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    public MovieDto findById(Long id){
        return MovieMapper.map(findByIdPrivate(id));
    }

    private Movie findByIdPrivate(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundMyException("Failed to save a movie with an ID: " + id));
    }

    public MovieDto updateMovie(Long id, MovieUpdateRequest movieUpdateRequest){

        Movie movie = findByIdPrivate(id);
        movie.setTitle(movieUpdateRequest.getTitle());
        movie.setYear(movieUpdateRequest.getYear());
        return MovieMapper.map(movieRepository.save(movie));
    }

    public boolean exists(Long id){
        if(movieRepository.existsById(id))
            return true;
        else
            return false;
    }

    public List<MovieDto> findAll(){
        return movieRepository.findAll()
                .stream()
                .map(MovieMapper::map)
                .collect(Collectors.toList());
    }

    public List<MovieDto> getMoviesFromCategory(Category category){
        return movieRepository.findAllByCategory(category)
                .stream()
                .map(MovieMapper::map)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id){
        movieRepository.deleteById(id);
    }

    public Movie addNewMovie(MovieRequest movieRequest, Long id) {
        //movie.setId(movieIdGeneratorService.generateId());
        //movieValidator.validateMovie(movie);
        Movie movie = findByIdPrivate(id);

        //TODO: Ogarnąć czy wysyłać całego Directora czy tylko zmieniane
        //      propercje w tym requescie
        movie.setYear(movieRequest.getYear());
        movie.setLengthInMinutes(movieRequest.getLengthInMinutes());
        if(movieRequest.getTitle().length()>0)
            movie.setTitle(movieRequest.getTitle());
        if(movieRequest.getCategory() != null)
            movie.setCategory(movieRequest.getCategory());
        if(movieRequest.getDirector() != null) {
            movie.getDirector().setLastName(movieRequest.getDirector().getLastName());
            movie.getDirector().setFirstName(movieRequest.getDirector().getFirstName());
        }
        if(movieRequest.getRating() != null)
            movie.getRating().setScore(movieRequest.getRating().getScore());
        return movieRepository.save(movie);
    }

//    public Set<Movie> getMoviesByActorsName(String name)
//    {
//        List<Actor> actors = actorRepository.findAllByFirstName(name);
//        Set<Movie> movieSet = new TreeSet<>();
//
//        for (Actor actor:actors) {
//            for (Movie movie : movieRepository.findAllByActors(actor)) {
//                movieSet.add(movie);
//            }
//        }
//        //actors.forEach(actor -> movieRepository.findAllByActors(actor).forEach(movieSet::add));
//        return movieSet;


       // movieRepository.findAllByActors()
//    }
    public List<ActorDto> getActorsByMovie(Long movieId)
    {
        return actorRepository.findAllByMovies(findByIdPrivate(movieId))
                .stream()
                .map(ActorMapper::map)
                .collect(Collectors.toList());
    }

    public List<Actor> findActorsByFirstName(String firstName)
    {
        return actorRepository.findAllByFirstName(firstName);
    }
}
