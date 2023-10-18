package kr.ecocow.ecomovie.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class CompanyTests {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @DisplayName("Company 엔티티 매핑")
    private void findCompany() {
        entityManager.find(Company.class, 1L);
    }
}
