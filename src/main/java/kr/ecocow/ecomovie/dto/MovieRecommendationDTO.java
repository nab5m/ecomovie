package kr.ecocow.ecomovie.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.querydsl.core.annotations.QueryProjection;
import kr.ecocow.ecomovie.constant.ContentTypeCode;
import kr.ecocow.ecomovie.entity.ContentGenre;
import kr.ecocow.ecomovie.entity.ContentVoteSummary;
import kr.ecocow.ecomovie.entity.Language;
import kr.ecocow.ecomovie.entity.Movie;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MovieRecommendationDTO {
    private Boolean adult;
    private String backdropPath;
    private Long id;
    private String title;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private String posterPath;
    private String mediaType;
    private List<Integer> genreIds;
    private Double popularity;
    private LocalDate releaseDate;
    private Boolean video;
    private Double voteAverage;
    private Long voteCount;

    @QueryProjection
    public MovieRecommendationDTO(Movie movie, Set<ContentGenre> genres, ContentVoteSummary contentVoteSummary) {
        this.adult = movie.getAdult();
        this.backdropPath = movie.getBackdropPath();
        this.id = movie.getMovieId();
        Language language = movie.getLanguage();
        if (language != null) {
            this.originalLanguage = language.getIso_639_1();
        }
        this.originalTitle = movie.getOriginalTitle();
        this.overview = movie.getOverview();
        this.posterPath = movie.getPosterPath();
        this.mediaType = ContentTypeCode.Movie.getEnglishName();
        this.genreIds = genres.stream().map(ContentGenre::getGenreCode).toList();
        this.popularity = movie.getPopularity();
        this.releaseDate = movie.getReleaseDate();
        this.video = movie.getVideo();
        if (contentVoteSummary != null) {
            this.voteAverage = contentVoteSummary.getVoteAverageRating();
            this.voteCount = contentVoteSummary.getVoteCount();
        }
    }
}
