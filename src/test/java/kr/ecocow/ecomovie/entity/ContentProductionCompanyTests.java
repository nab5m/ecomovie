package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class ContentProductionCompanyTests {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @DisplayName("ContentProductionCompany 엔티티 매핑")
    public void findContentProductionCompany() {
        entityManager.find(ContentProductionCompany.class, 1L);
    }
}
