package kr.ecocow.ecomovie.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContentGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(value = 0)
    private Long contentGenreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private int contentTypeCode;

    private int genreCode;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
}
