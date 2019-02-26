//package com.infoshare.test.service;
//
//import com.infoshare.test.model.Movie;
//import com.infoshare.test.repository.MovieRepository;
//import com.infoshare.test.repository.MovieRepositoryOld;
//import com.infoshare.test.validation.MovieValidator;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MovieInsertServiceTest {
//
//    @Mock
//    private MovieValidator movieValidator;
//
//    @Mock
//    private MovieIdGeneratorService movieIdGeneratorService;
//
//    @Mock
//    private MovieRepository movieRepository;
//
//    @InjectMocks
//    private MovieInsertService movieInsertService;
//
//    @Test
//    public void testInsert() {
//        // given
//        Movie movie = new Movie();
//
//        when(movieIdGeneratorService.generateId()).thenReturn(1L);
//        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
//
//        // when
//        Movie savedMovie = movieInsertService.addNewMovie(movie);
//
//        // then
//       // verify(movieValidator, Mockito.times(1)).validateMovie(movie);
//        assertThat(savedMovie).isEqualTo(movie);
//    }
//}