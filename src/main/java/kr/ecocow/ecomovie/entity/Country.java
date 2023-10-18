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
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long countryId;

    @Size(max = 256)
    private String countryName;

    @Size(max = 10)
    private String iso_3166_1;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
}
