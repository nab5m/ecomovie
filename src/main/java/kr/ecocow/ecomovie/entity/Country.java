package kr.ecocow.ecomovie.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
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
