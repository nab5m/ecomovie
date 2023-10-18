package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class ContentGenreTests {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @DisplayName("ContentGenre 엔티티 매핑")
    public void findContentGenre() {
        entityManager.find(ContentGenre.class, 1L);
    }
}
