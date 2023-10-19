package kr.ecocow.ecomovie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ContentTypeCode {
    Movie(0, "movie");

    private final int code;
    private final String englishName;
}
