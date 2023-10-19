package kr.ecocow.ecomovie.service;

import kr.ecocow.ecomovie.dto.MovieDetailsDTO;
import kr.ecocow.ecomovie.dto.MovieRecommendationDTO;
import kr.ecocow.ecomovie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public @Nullable MovieDetailsDTO getMovieDetails(Long movieId) {
        return movieRepository.findMovieDetails(movieId);
    }

    @Transactional(readOnly = true)
    // page는 0부터 시작
    public @Nullable List<MovieRecommendationDTO> getMovieRecommendationList(Long movieId, int page) {
        boolean movieExists = movieRepository.checkMovieExists(movieId);
        if (!movieExists) {
            return null;
        }

        List<Long> movieIdList = movieRepository.findMovieRecommendationIdList(movieId);

        int rowPerPage = 20;
        List<Long> paginatedMovieIdList = movieIdList.subList(rowPerPage * page, rowPerPage * (page + 1));
        return movieRepository.findMovieRecommendationList(paginatedMovieIdList);
    }
}
