package kr.ecocow.ecomovie.service;

import kr.ecocow.ecomovie.constant.AppendToResponse;
import kr.ecocow.ecomovie.dto.*;
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
    private final TranslationService translationService;
    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public @Nullable MovieDetailsDTO getMovieDetails(Long movieId, @Nullable MovieDetailsRequestDTO movieDetailsRequestDTO) {
        MovieDetailsDTO movieDetailsDTO = movieRepository.findMovieDetails(movieId);

        if (movieDetailsDTO == null) {
            return null;
        }
        if (movieDetailsRequestDTO == null) {
            return movieDetailsDTO;
        }

        movieDetailsDTO = translateMovieTitle(movieDetailsRequestDTO, movieDetailsDTO);
        movieDetailsDTO = appendToMovieDetailsResponse(movieDetailsRequestDTO, movieDetailsDTO);

        return movieDetailsDTO;
    }

    private MovieDetailsDTO translateMovieTitle(MovieDetailsRequestDTO movieDetailsRequestDTO, MovieDetailsDTO movieDetailsDTO) {
        // 제목 번역 : api 무료 사용량을 고려해서 영화 상세 API의 영화 제목만 번역했습니다.
        String targetLanguage = movieDetailsRequestDTO == null ? null : movieDetailsRequestDTO.getLanguage();
        String sourceLanguage = null;
        String originalTitle = null;
        if (movieDetailsDTO.getMovie() != null) {
            sourceLanguage = movieDetailsDTO.getMovie().getOriginalLanguage();
            originalTitle = movieDetailsDTO.getMovie().getOriginalTitle();
        }

        String translatedTitle = originalTitle;
        if (sourceLanguage != null && targetLanguage != null && originalTitle != null) {
            String translationResult = translationService.translate(originalTitle, sourceLanguage, targetLanguage);
            if (translationResult != null) {
                translatedTitle = translationResult;
            }
        }

        return movieDetailsDTO.withTitle(translatedTitle);
    }

    private MovieDetailsDTO appendToMovieDetailsResponse(MovieDetailsRequestDTO movieDetailsRequestDTO, MovieDetailsDTO movieDetailsDTO) {
        AppendToResponse appendToResponse = movieDetailsRequestDTO.getAppend_to_response();
        if (appendToResponse == null) {
            return movieDetailsDTO;
        }

        switch (appendToResponse) {
            case Recommendations:
                if (movieDetailsDTO.getMovie() == null) {
                    return movieDetailsDTO;
                }

                return movieDetailsDTO.toBuilder()
                        .recommendations(getMovieRecommendationList(movieDetailsDTO.getMovie().getId(), null))
                        .build();
            default:
                return movieDetailsDTO;
        }
    }

    @Transactional(readOnly = true)
    // page는 1부터 시작
    public @Nullable MovieRecommendationResponseDTO getMovieRecommendationList(Long movieId,
                                                                               @Nullable MovieRecommendationRequestDTO movieRecommendationRequestDTO) {
        boolean movieExists = movieRepository.checkMovieExists(movieId);
        if (!movieExists) {
            return null;
        }

        List<Long> movieIdList = movieRepository.findMovieRecommendationIdList(movieId);

        int rowPerPage = 20;
        int totalResults = movieIdList.size();
        int totalPages = totalResults == 0 ? 1 : (totalResults - 1) / rowPerPage + 1;

        List<MovieRecommendationDTO> results = List.of();

        int page = movieRecommendationRequestDTO == null ? 1 : movieRecommendationRequestDTO.getPage();
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
