package kr.ecocow.ecomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CodeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(value = 0)
    private Long codeCategoryId;

    @NotBlank
    @Size(max = 30)
    private String codeCategoryName;

    @Embedded
    private TimestampEmbeddable timestampEmbeddable;
}
