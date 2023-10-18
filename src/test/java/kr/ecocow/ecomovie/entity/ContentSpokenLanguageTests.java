package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class ContentSpokenLanguageTests {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @DisplayName("ContentSpokenLanguage 엔티티 매핑")
    public void findContentSpokenLanguage() {
        entityManager.find(ContentSpokenLanguage.class, 1L);
    }
}
