package kr.ecocow.ecomovie.dto;

import lombok.*;

import javax.validation.constraints.Positive;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieRecommendationRequestDTO {
    private String language;
    @Positive
    private int page = 1;
}
