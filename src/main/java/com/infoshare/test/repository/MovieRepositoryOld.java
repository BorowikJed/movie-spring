package com.infoshare.test.repository;

import com.infoshare.test.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryOld {

    private List<Movie> movies = new ArrayList<>();

    public Movie save(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public Optional<Movie> findById(Long id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();
    }

    public List<Movie> findAll() {
        return List.copyOf(movies);
    }

    public long count() {
        return movies.size();
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(movies::remove);
    }

    public boolean exists(Movie movie) {
        return movies.contains(movie);
    }
}
