package kr.ecocow.ecomovie.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TranslationServiceTests {
    @Autowired
    private TranslationService translationService;

    @Test
    @DisplayName("translate 지원하지 않는 언어")
    public void translateNotSupportedLanguage() {
        String result = translationService.translate("Hello World", "en", "not supported language");
        assertNull(result);
    }

    @Test
    @DisplayName("translate 성공")
    public void translateSuccess() {
        String result = translationService.translate("안녕", "ko", "en");
        System.out.println("번역 결과: " + result);
        assertNotNull(result);
    }
}
