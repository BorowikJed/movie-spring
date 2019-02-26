package com.infoshare.test.repository;

import com.infoshare.test.model.Actor;
import com.infoshare.test.model.Category;
import com.infoshare.test.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.CacheRequest;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByCategory(Category category);

    List<Movie> findAllByActors(Actor actor);

    boolean existsById(Long id);
}
