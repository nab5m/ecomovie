package kr.ecocow.ecomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long collectionId;

    @NotBlank
    @Size(max = 1024)
    private String name;

    @URL
    @Size(max = 1024)
    private String posterPath;

    @URL
    @Size(max = 1024)
    private String backdropPath;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
}
