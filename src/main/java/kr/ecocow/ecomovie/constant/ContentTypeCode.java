package kr.ecocow.ecomovie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ContentTypeCode {
    Movie(0);

    private final int code;
}
