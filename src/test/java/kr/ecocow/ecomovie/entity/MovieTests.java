package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class MovieTests {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Test
    @DisplayName("Movie 엔티티 매핑")
    public void findMovie() {
        entityManager.find(Movie.class, 1L);
    }
}
