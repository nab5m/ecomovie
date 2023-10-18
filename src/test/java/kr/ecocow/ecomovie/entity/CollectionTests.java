package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class CollectionTests {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Test
    @DisplayName("Collection 엔티티 매핑")
    public void findCollection() {
        entityManager.find(Collection.class, 1L);
    }
}
