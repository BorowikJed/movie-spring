package com.infoshare.test;

import com.infoshare.test.model.*;
import com.infoshare.test.repository.ActorRepository;
import com.infoshare.test.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
//
//
//	@Autowired
//    MovieRepository movieRepository;
//	@Autowired
//	ActorRepository actorRepository;
//
//
//	public void run(String... args) throws Exception {
//


}