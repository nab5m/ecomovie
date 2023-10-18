package kr.ecocow.ecomovie.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ecocow.ecomovie.constant.CodeCategoryName;
import kr.ecocow.ecomovie.dto.*;
import kr.ecocow.ecomovie.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import static com.querydsl.core.group.GroupBy.*;

@Repository
@RequiredArgsConstructor
public class MovieRepository {
    private final JPAQueryFactory jpaQueryFactory;

    private final QMovie qMovie = QMovie.movie;
    private final QLanguage qLanguage = QLanguage.language;
    private final QContentSpokenLanguage qContentSpokenLanguage = QContentSpokenLanguage.contentSpokenLanguage;
    private final QContentGenre qContentGenre = QContentGenre.contentGenre;
    private final QContentVoteSummary qContentVoteSummary = QContentVoteSummary.contentVoteSummary;
    private final QContentProductionCompany qContentProductionCompany = QContentProductionCompany.contentProductionCompany;
    private final QCompany qCompany = QCompany.company;
    private final QCountry qCountry = QCountry.country;
    private final QCodeItem qCodeItem = QCodeItem.codeItem;

    private final BooleanExpression qMovieIsNotDeleted = qMovie.timestampEmbeddable.deletionDateTime.isNull();

    public @Nullable MovieDetailsDTO findMovieDetails(Long movieId) {
        QCodeItem genreCode = new QCodeItem("genreCode");

        return jpaQueryFactory.from(qMovie)
                .leftJoin(qMovie.collection)
                .leftJoin(qCodeItem).on(qCodeItem.code.eq(qMovie.releaseStatusCode))
                .leftJoin(qCodeItem.codeCategory)
                .leftJoin(qMovie.language)
                .leftJoin(qContentVoteSummary).on(qContentVoteSummary.movie.eq(qMovie))
                .leftJoin(qContentGenre).on(qContentGenre.movie.eq(qMovie))
                .leftJoin(genreCode).on(genreCode.code.eq(qContentGenre.genreCode))
                .leftJoin(genreCode.codeCategory)
                .leftJoin(qContentSpokenLanguage).on(qContentSpokenLanguage.movie.eq(qMovie))
                .leftJoin(qLanguage).on(qContentSpokenLanguage.language.eq(qLanguage))
                .leftJoin(qContentProductionCompany).on(qContentProductionCompany.movie.eq(qMovie))
                .leftJoin(qCompany).on(qContentProductionCompany.company.eq(qCompany))
                .leftJoin(qCountry).on(qCompany.country.eq(qCountry))
                .where(qMovie.movieId.eq(movieId)
                        .and(qMovieIsNotDeleted)
                        .and(genreCode.codeCategory.codeCategoryName.eq(CodeCategoryName.Genre.getName()))
                        .and(qCodeItem.codeCategory.codeCategoryName.eq(CodeCategoryName.ReleaseStatus.getName())))
                .transform(
                        groupBy(qMovie.movieId).as(
                                new QMovieDetailsDTO(
                                        qMovie,
                                        qCodeItem,
                                        qContentVoteSummary,
                                        set(new QMovieDetailsDTO_GenreDTO(genreCode)),
                                        set(new QMovieDetailsDTO_ProductionCompanyDTO(qCompany)),
                                        set(new QMovieDetailsDTO_ProductionCountryDTO(qCountry)),
                                        set(new QMovieDetailsDTO_SpokenLanguageDTO(qLanguage))
                                )
                        )
                ).get(movieId);
    }
}
