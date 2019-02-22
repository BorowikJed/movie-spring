package com.infoshare.test.repository;

import com.infoshare.test.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Override
    public List<Actor> findAll() ;
}
