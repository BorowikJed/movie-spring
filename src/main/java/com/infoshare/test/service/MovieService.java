package com.infoshare.test.service;

import com.infoshare.test.exceptions.ResourceNotFoundMyException;
import com.infoshare.test.model.Category;
import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import com.infoshare.test.requests.MovieRequest;
import com.infoshare.test.requests.MovieUpdateRequest;
import com.infoshare.test.validation.MovieValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieValidator movieValidator;
    private final MovieRepository movieRepository;

    public MovieService(MovieValidator movieValidator, MovieRepository movieRepository) {
        this.movieValidator = movieValidator;
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundMyException("Failed to save a movie with an ID: " + id));
    }

    public Movie updateMovie(Long id, MovieUpdateRequest movieUpdateRequest){

        Movie movie = findById(id);
        movie.setTitle(movieUpdateRequest.getTitle());
        movie.setYear(movieUpdateRequest.getYear());
        return movieRepository.save(movie);
    }

    public boolean exists(Long id){
        if(movieRepository.existsById(id))
            return true;
        else
            return false;
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesFromCategory(Category category){
        return movieRepository.findAllByCategory(category);
    }

    public void deleteById(Long id){
        movieRepository.deleteById(id);
    }

    public Movie addNewMovie(MovieRequest movieRequest, Long id) {
        //movie.setId(movieIdGeneratorService.generateId());
        //movieValidator.validateMovie(movie);
        Movie movie = findById(id);

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
}
