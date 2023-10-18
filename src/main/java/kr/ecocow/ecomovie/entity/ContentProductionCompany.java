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
public class ContentProductionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(value = 0)
    private Long contentProductionCompanyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "production_movie_id")
    private Movie movie;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "production_company_id")
    private Company company;

    private int contentTypeCode;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
}
