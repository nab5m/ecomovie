package kr.ecocow.ecomovie.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ecocow.ecomovie.constant.CodeCategoryName;
import kr.ecocow.ecomovie.dto.*;
import kr.ecocow.ecomovie.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.querydsl.core.group.GroupBy.*;

@Repository
@RequiredArgsConstructor
public class MovieRepository {
    @PersistenceContext
    private EntityManager entityManager;

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

    // ToDo: Q객체를 직접 만드는 경우 해당 Q객체에 대한 조건으로 사용할 것
    private final BooleanExpression qMovieIsNotDeleted = qMovie.timestampEmbeddable.deletionDateTime.isNull();
    private final BooleanExpression qContentGenreIsNotDeleted = qContentGenre.timestampEmbeddable.deletionDateTime.isNull();
    private final BooleanExpression qContentVoteSummaryIsNotDeleted = qContentVoteSummary.timestampEmbeddable.deletionDateTime.isNull();

    public boolean checkMovieExists(Long movieId) {
        Long count = jpaQueryFactory.from(qMovie)
                .select(qMovie.count())
                .where(qMovie.movieId.eq(movieId)
                        .and(qMovieIsNotDeleted))
                .fetchOne();

        return count != null && count >= 1;
    }

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
                                        set(genreCode),
                                        set(qCompany),
                                        set(qCountry),
                                        set(qLanguage)
                                )
                        )
                ).get(movieId);
    }

    public List<Long> findMovieRecommendationIdList(Long movieId) {
        int collectionScoreWeight = 5;
        int genreScoreWeight = 3;
        int productionCompanyWeight = 2;
        double voteAverageRatingWeight = 0.5;
        double popularityWeight = 0.3;

        // 같은 컬렉션에 속한 영화면 collectionScoreWeight 만큼 점수 증가
        String findCollectionMatchedMovieList =
                " (SELECT m2.movie_id, COUNT(*) * " + collectionScoreWeight + " AS score " +
                "       FROM movie m2 " +
                "    WHERE m2.movie_collection_id = (SELECT m1.movie_collection_id " +
                "           FROM movie m1 " +
                "               WHERE m1.movie_id = " + movieId + " " +
                "                   AND m1.deletion_date_time IS NULL) " +
                "       AND m2.deletion_date_time IS NULL " +
                " ) ";

        // 점수 = 일치하는 장르 개수 * genreScoreWeight
        String findGenreMatchedMovieList =
                " (SELECT cg2.movie_id, COUNT(*) * " + genreScoreWeight +" AS score " +
                "    FROM content_genre cg2 " +
                "    WHERE cg2.genre_code IN (SELECT cg1.genre_code " +
                "            FROM content_genre cg1 " +
                "               WHERE cg1.movie_id = " + movieId + " " +
                "                   AND cg1.deletion_date_time IS NULL) " +
                "       AND cg2.deletion_date_time IS NULL " +
                "    GROUP BY cg2.movie_id) ";

        // 점수 = 일치하는 제작사 개수 * productionCompanyWeight
        String findProductionCompanyMatchedMovieList =
                " (SELECT cpc2.production_movie_id, COUNT(*) * " + productionCompanyWeight + " AS score " +
                "    FROM content_production_company cpc2 " +
                "    WHERE cpc2.production_company_id IN (SELECT cpc1.production_company_id " +
                "            FROM content_production_company cpc1 " +
                "               WHERE cpc1.production_movie_id = " + movieId + " " +
                "                    AND cpc1.deletion_date_time IS NULL) " +
                "       AND cpc2.deletion_date_time IS NULL" +
                "    GROUP BY cpc2.production_movie_id) ";

        // 중간 점수 = (컬렌션 점수 + 장르 점수 + 제작사 점수)
        // 최종 점수 = 중간 점수 + (투표평점 * voteAverageRatingWeight) + (인기도 * popularityWeight)
        String findRecommendedMovieIdList =
                " SELECT movie.movie_id " +
                " FROM movie " +
                " INNER JOIN (SELECT movie_id, SUM(score) AS level1_score " +
                "   FROM ( " + findCollectionMatchedMovieList + " UNION ALL "
                    + findGenreMatchedMovieList + " UNION ALL " + findProductionCompanyMatchedMovieList + " ) AS level1_result " +
                "    GROUP BY movie_id " +
                "    ORDER BY level1_score DESC" +
                "    LIMIT 100) AS level1_aggregation " +
                " ON movie.movie_id = level1_aggregation.movie_id " +
                " LEFT JOIN content_vote_summary cvs ON cvs.movie_id = movie.movie_id " +
                " WHERE movie.deletion_date_time IS NULL " +
                "   AND cvs.deletion_date_time IS NULL " +
                "   AND movie.movie_id != " + movieId + " " +
                " ORDER BY (level1_score + cvs.vote_average_rating * " + voteAverageRatingWeight
                        + " + popularity * " + popularityWeight + ") DESC; ";

        return entityManager.createNativeQuery(findRecommendedMovieIdList)
                .getResultList()
                .stream()
                .map(resultMovieId -> (Long.parseLong(String.valueOf(resultMovieId))))
                .toList();
    }

    public List<MovieRecommendationDTO> findMovieRecommendationList(List<Long> movieIdList) {
        return jpaQueryFactory.from(qMovie)
                .leftJoin(qMovie.language)
                .leftJoin(qContentGenre).on(qContentGenre.movie.eq(qMovie))
                .leftJoin(qContentVoteSummary).on(qContentVoteSummary.movie.eq(qMovie))
                .where(qMovie.movieId.in(movieIdList)
                        .and(qMovieIsNotDeleted)
                        .and(qContentGenreIsNotDeleted)
                        .and(qContentVoteSummaryIsNotDeleted))
                .transform(
                        groupBy(qMovie.movieId).list(
                                new QMovieRecommendationDTO(qMovie, set(qContentGenre), qContentVoteSummary)
                        )
                );
    }
}
