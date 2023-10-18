package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class LanguageTests {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Test
    @DisplayName("Language 엔티티 매핑")
    public void findLanguage() {
        entityManager.find(Language.class, 1L);
    }
}
