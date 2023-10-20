package kr.ecocow.ecomovie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PapagoTranslationRequestDTO {
    private String source;
    private String target;
    private String text;
}
