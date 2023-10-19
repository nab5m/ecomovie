package kr.ecocow.ecomovie.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ecocow.ecomovie.controller.exception.NotFoundException;
import kr.ecocow.ecomovie.controller.swagger.MovieControllerDocs;
import kr.ecocow.ecomovie.dto.MovieDetailsDTO;
import kr.ecocow.ecomovie.dto.MovieRecommendationResponseDTO;
import kr.ecocow.ecomovie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
@Tag(name = "MovieController", description = "영화 컨트롤러")
public class MovieController {
    private final MovieService movieService;

    public static final String MOVIE_NOT_FOUND_MESSAGE = "존재하지 않는 영화입니다.";

    @GetMapping("{movieId}")
    @MovieControllerDocs.GetMovieDetails
    public MovieDetailsDTO getMovieDetails(@PathVariable long movieId) {
        MovieDetailsDTO movieDetailsDTO = movieService.getMovieDetails(movieId);

        if (movieDetailsDTO == null) {
            throw new NotFoundException(MOVIE_NOT_FOUND_MESSAGE);
        }

        return movieDetailsDTO;
    }

    @GetMapping("{movieId}/recommendations")
    @MovieControllerDocs.GetMovieRecommendations
    public MovieRecommendationResponseDTO getMovieRecommendations(@PathVariable long movieId,
                                                                  @RequestParam(defaultValue = "1") int page)
    {
        MovieRecommendationResponseDTO movieRecommendationResponseDTO = movieService.getMovieRecommendationList(movieId, page);

        if (movieRecommendationResponseDTO == null) {
            throw new NotFoundException(MOVIE_NOT_FOUND_MESSAGE);
        }

        return movieRecommendationResponseDTO;
    }
}
