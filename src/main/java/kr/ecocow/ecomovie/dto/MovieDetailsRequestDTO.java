package kr.ecocow.ecomovie.dto;

import kr.ecocow.ecomovie.constant.AppendToResponse;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDetailsRequestDTO {
    // @JsonNaming이나 @JsonProperty로 case변경 시 enum 값이 세팅되지 않는 문제가 발생
    private AppendToResponse append_to_response;
    private String language;
}
