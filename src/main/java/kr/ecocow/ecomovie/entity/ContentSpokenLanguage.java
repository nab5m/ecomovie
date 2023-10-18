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
public class ContentSpokenLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(value = 0)
    private Long contentSpokenLanguageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "spoken_language_id")
    private Language language;

    private int contentTypeCode;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
}
