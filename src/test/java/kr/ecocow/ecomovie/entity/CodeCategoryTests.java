package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class CodeCategoryTests {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @DisplayName("CodeCategory 엔티티 매핑")
    public void findCodeCategory() {
        entityManager.find(CodeCategory.class, 1L);
    }
}
