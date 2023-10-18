package kr.ecocow.ecomovie.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.querydsl.core.annotations.QueryProjection;
import kr.ecocow.ecomovie.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MovieDetailsDTO {
    // ToDo: 응답으로 줄 때 snake_case로 변환하기
    
    @JsonUnwrapped
    private MovieDTO movie;
    private CollectionDTO belongsToCollection;
    private Set<GenreDTO> genres;
    private Set<ProductionCompanyDTO> productionCompanies;
    private Set<ProductionCountryDTO> productionCountries;
    private Set<SpokenLanguageDTO> spokenLanguages;

    @QueryProjection
    public MovieDetailsDTO(Movie movie, CodeItem releaseStatus, ContentVoteSummary contentVoteSummary,
                           Set<GenreDTO> genres, Set<ProductionCompanyDTO> productionCompanies,
                           Set<ProductionCountryDTO> productionCountries, Set<SpokenLanguageDTO> spokenLanguages) {
        this.movie = MovieDTO.fromEntity(movie, releaseStatus, contentVoteSummary);
        Collection collection = movie.getCollection();
        if (collection != null) {
            this.belongsToCollection = CollectionDTO.fromEntity(collection);
        }
        this.genres = genres;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.spokenLanguages = spokenLanguages;
    }

    @Builder
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class MovieDTO {
        private Long id;
        private String imdbId;
        private String backdropPath;
        private String posterPath;
        private String originalLanguage;
        private String originalTitle;
        private String title;
        private String overview;
        private Double voteAverage;
        private Long voteCount;
        private Double popularity;
        private Long budget;
        private Long revenue;
        private Long runtime;
        private LocalDate releaseDate;
        private String status;
        private Boolean adult;
        private Boolean video;

        public static MovieDTO fromEntity(Movie movie, CodeItem releaseStatus, ContentVoteSummary contentVoteSummary) {
            return MovieDTO.builder()
                    .id(movie.getMovieId())
                    .imdbId(movie.getImdbId())
                    .backdropPath(movie.getBackdropPath())
                    .posterPath(movie.getPosterPath())
                    .originalLanguage(movie.getLanguage() != null ? movie.getLanguage().getIso_639_1() : null)
                    .originalTitle(movie.getOriginalTitle())
                    .overview(movie.getOverview())
                    .voteAverage(contentVoteSummary.getVoteAverageRating())
                    .voteCount(contentVoteSummary.getVoteCount())
                    .popularity(movie.getPopularity())
                    .budget(movie.getBudget())
                    .revenue(movie.getRevenue())
                    .runtime(movie.getRuntime())
                    .releaseDate(movie.getReleaseDate())
                    .status(releaseStatus.getCodeItemName())
                    .adult(movie.getAdult())
                    .video(movie.getVideo())
                    .build();
        }
    }

    @Builder
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CollectionDTO {
        private Long id;
        private String name;
        private String posterPath;
        private String backdropPath;

        public static CollectionDTO fromEntity(Collection collection) {
            return CollectionDTO.builder()
                    .id(collection.getCollectionId())
                    .name(collection.getName())
                    .posterPath(collection.getPosterPath())
                    .backdropPath(collection.getBackdropPath())
                    .build();
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class GenreDTO {
        private Long id;
        private String name;

        @QueryProjection
        public GenreDTO(CodeItem codeItem) {
            this.id = (long) codeItem.getCode();
            this.name = codeItem.getCodeItemName();
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class ProductionCompanyDTO {
        private Long id;
        private String logoPath;
        private String name;
        private String originCountry;

        @QueryProjection
        public ProductionCompanyDTO(Company company) {
            this.id = company.getCompanyId();
            this.logoPath = company.getLogoPath();
            this.name = company.getCompanyName();
            Country country = company.getCountry();
            if (country != null) {
                this.originCountry = country.getIso_3166_1();
            }
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class ProductionCountryDTO {
        private String iso_3166_1;
        private String name;

        @QueryProjection
        public ProductionCountryDTO(Country country) {
            this.iso_3166_1 = country.getIso_3166_1();
            this.name = country.getCountryName();
        }
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class SpokenLanguageDTO {
        private String englishName;
        private String iso_639_1;
        private String name;

        @QueryProjection
        public SpokenLanguageDTO(Language language) {
            this.englishName = language.getEnglishName();
            this.name = language.getLanguageName();
            this.iso_639_1 = language.getIso_639_1();
        }
    }
}
