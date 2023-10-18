package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class CodeItemTests {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Test
    @DisplayName("CodeItem 엔티티 매핑")
    public void findCodeItem() {
        entityManager.find(CodeItem.class, 1L);
    }
}
