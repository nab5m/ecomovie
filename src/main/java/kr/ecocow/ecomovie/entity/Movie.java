package kr.ecocow.ecomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_collection_id")
    private Collection collection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private Language language;

    @Size(max = 30)
    private String imdbId;

    @Size(max = 1024)
    private String originalTitle;

    private String overview;

    @URL
    @Size(max = 1024)
    private String homepage;

    @URL
    @Size(max = 1024)
    private String backdropPath;

    @URL
    @Size(max = 1024)
    private String posterPath;

    private LocalDate releaseDate;

    private Integer releaseStatusCode;

    @Min(value = 0)
    private Long budget;

    private Long revenue;

    @Min(value = 0)
    private Long runtime;

    private Double popularity;

    private Boolean adult;

    private Boolean video;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
    
    // ToDo: tagline 칼럼 누락됐음
}
