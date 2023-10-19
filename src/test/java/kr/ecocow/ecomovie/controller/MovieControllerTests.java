package kr.ecocow.ecomovie.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTests {
    @Autowired
    private MovieController movieController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("영화 상세 페이지 정상 작동하는지 확인")
    public void getMovieDetailsSuccess() throws Exception {
        long movieId = 1L;
        mockMvc.perform(get("/api/v1/movie/" + movieId));
    }

    @Test
    @DisplayName("영화 추천 목록 조회 정상 작동하는지 확인")
    public void getMovieRecommendationsSuccess() throws Exception {
        long movieId = 1L;
        mockMvc.perform(get("/api/v1/movie/" + movieId + "/recommendations"));
    }
}
