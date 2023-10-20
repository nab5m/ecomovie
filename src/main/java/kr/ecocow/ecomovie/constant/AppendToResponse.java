package kr.ecocow.ecomovie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AppendToResponse {
    Recommendations("recommendations");

    private final String requestParameterName;
}
