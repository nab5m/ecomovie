package kr.ecocow.ecomovie.controller.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kr.ecocow.ecomovie.controller.MovieController;
import kr.ecocow.ecomovie.dto.MovieDetailsDTO;
import kr.ecocow.ecomovie.dto.MovieRecommendationResponseDTO;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MovieControllerDocs {
    @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(summary = "영화 상세 페이지 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "영화 상세 페이지 조회 성공",
                    content = @Content(schema = @Schema(implementation = MovieDetailsDTO.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 영화",
                    content = @Content(schema = @Schema(example = MovieController.MOVIE_NOT_FOUND_MESSAGE)))
    })
    public @interface GetMovieDetails { }

    @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(summary = "추천 영화 목록 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "추천 영화 목록 조회 성공",
                    content = @Content(schema = @Schema(implementation = MovieRecommendationResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 영화",
                    content = @Content(schema = @Schema(example = MovieController.MOVIE_NOT_FOUND_MESSAGE)))
    })
    public @interface GetMovieRecommendations { }
}
