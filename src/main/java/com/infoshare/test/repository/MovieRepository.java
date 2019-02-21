package com.infoshare.test.repository;

import com.infoshare.test.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllById(Long id);
}
