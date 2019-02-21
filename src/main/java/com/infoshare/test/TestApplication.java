package com.infoshare.test;

import com.infoshare.test.model.Movie;
import com.infoshare.test.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}


	@Autowired
    MovieRepository movieRepository;


	public void run(String... args) throws Exception {


		Movie movie = new Movie();
		movie.setTitle("MOVIEEEEE");
		//movie.setId(1L);
        System.out.println(movie);
        movieRepository.save(movie);
		System.out.println(movieRepository.findAll());
		System.out.println("LALALALALALALALALALALALALALALALALALALALA");




	}
}