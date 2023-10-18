package kr.ecocow.ecomovie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodeCategoryName {
    ReleaseStatus("개봉상태"),
    Genre("장르");

    private final String name;
}
