package kr.ecocow.ecomovie.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieRepositoryTests {
    @Autowired
    private MovieRepository movieRepository;
    
    @Test
    @DisplayName("findMovieDetails 쿼리 확인")
    public void findMovieDetails() {
        movieRepository.findMovieDetails(1L);
    }
}
