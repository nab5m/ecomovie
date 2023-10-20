package kr.ecocow.ecomovie.service;

import kr.ecocow.ecomovie.dto.MovieDetailsDTO;
import kr.ecocow.ecomovie.dto.MovieDetailsRequestDTO;
import kr.ecocow.ecomovie.dto.MovieRecommendationDTO;
import kr.ecocow.ecomovie.dto.MovieRecommendationResponseDTO;
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
    public @Nullable MovieDetailsDTO getMovieDetails(Long movieId, @Nullable MovieDetailsRequestDTO movieDetailsRequestDTO) {
        return movieRepository.findMovieDetails(movieId);
    }

    @Transactional(readOnly = true)
    // page는 1부터 시작
    public @Nullable MovieRecommendationResponseDTO getMovieRecommendationList(Long movieId, int page) {
        boolean movieExists = movieRepository.checkMovieExists(movieId);
        if (!movieExists) {
            return null;
        }

        List<Long> movieIdList = movieRepository.findMovieRecommendationIdList(movieId);

        int rowPerPage = 20;
        int totalResults = movieIdList.size();
        int totalPages = totalResults == 0 ? 1 : (totalResults - 1) / rowPerPage + 1;

        List<MovieRecommendationDTO> results = List.of();

        if (0 < page && page <= totalPages) {
            List<Long> paginatedMovieIdList = movieIdList.subList(rowPerPage * (page - 1), Math.min(rowPerPage * page, totalResults));
            results = movieRepository.findMovieRecommendationList(paginatedMovieIdList);;
        }

        return MovieRecommendationResponseDTO.builder()
                .page(page)
                .results(results)
                .totalPages(totalPages)
                .totalResults(totalResults)
                .build();
    }
}
