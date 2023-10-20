package kr.ecocow.ecomovie.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieServiceTests {
    @Autowired
    private MovieService movieService;
    
    @Test
    @DisplayName("getMovieDetails 정상 작동하는지 확인")
    public void getMovieDetails() {
        movieService.getMovieDetails(1L, null);
    }

    @Test
    @DisplayName("getMovieRecommendationList 정상 작동하는지 확인")
    public void getMovieRecommendationList() {
        movieService.getMovieRecommendationList(1L, 1);
    }
}
