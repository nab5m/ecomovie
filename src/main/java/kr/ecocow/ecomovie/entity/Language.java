package kr.ecocow.ecomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long languageId;

    @Size(max = 256)
    private String languageName;

    @Size(max = 256)
    private String englishName;

    @Size(max = 10)
    private String iso_639_1;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
}
