package kr.ecocow.ecomovie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.querydsl.core.annotations.QueryProjection;
import kr.ecocow.ecomovie.entity.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MovieDetailsDTO {
    // ToDo: 응답으로 줄 때 snake_case로 변환하기
    
    @JsonUnwrapped
    private MovieDTO movie;
    private CollectionDTO belongsToCollection;
    private List<GenreDTO> genres;
    private List<ProductionCompanyDTO> productionCompanies;
    private List<ProductionCountryDTO> productionCountries;
    private List<SpokenLanguageDTO> spokenLanguages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MovieRecommendationResponseDTO recommendations;

    @QueryProjection
    public MovieDetailsDTO(Movie movie, CodeItem releaseStatus, ContentVoteSummary contentVoteSummary,
                           Set<CodeItem> genres, Set<Company> productionCompanies,
                           Set<Country> productionCountries, Set<Language> spokenLanguages) {
        this.movie = MovieDTO.fromEntity(movie, releaseStatus, contentVoteSummary);
        Collection collection = movie.getCollection();
        if (collection != null) {
            this.belongsToCollection = CollectionDTO.fromEntity(collection);
        }
        this.genres = genres.stream().map(GenreDTO::fromEntity).toList();
        this.productionCompanies = productionCompanies.stream().map(ProductionCompanyDTO::fromEntity).toList();
        this.productionCountries = productionCountries.stream().map(ProductionCountryDTO::fromEntity).toList();
        this.spokenLanguages = spokenLanguages.stream().map(SpokenLanguageDTO::fromEntity).toList();
    }

    public MovieDetailsDTO withTitle(String title) {
        return this.toBuilder()
                .movie(this.movie.toBuilder().title(title).build())
                .build();
    }

    @Builder(toBuilder = true)
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

        public static GenreDTO fromEntity(CodeItem codeItem) {
            return GenreDTO.builder()
                    .id((long) codeItem.getCode())
                    .name(codeItem.getCodeItemName())
                    .build();
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

        public static ProductionCompanyDTO fromEntity(Company company) {
            return ProductionCompanyDTO.builder()
                    .id(company.getCompanyId())
                    .logoPath(company.getLogoPath())
                    .name(company.getCompanyName())
                    .originCountry(company.getCountry() != null ? company.getCountry().getIso_3166_1() : null)
                    .build();
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

        public static ProductionCountryDTO fromEntity(Country country) {
            return ProductionCountryDTO.builder()
                    .iso_3166_1(country.getIso_3166_1())
                    .name(country.getCountryName())
                    .build();
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

        public static SpokenLanguageDTO fromEntity(Language language) {
            return SpokenLanguageDTO.builder()
                    .englishName(language.getEnglishName())
                    .iso_639_1(language.getIso_639_1())
                    .name(language.getLanguageName())
                    .build();
        }
    }
}
