package kr.ecocow.ecomovie.service;

import kr.ecocow.ecomovie.dto.PapagoTranslationRequestDTO;
import kr.ecocow.ecomovie.dto.PapagoTranslationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class TranslationService {
    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(TranslationService.class);

    private static final String PAPAGO_API_URL = "https://openapi.naver.com/v1/papago/n2mt";

    @Value("${naver.developers.client.id:}")
    private String NAVER_CLIENT_ID;

    @Value("${naver.developers.client.secret:}")
    private String NAVER_CLIENT_SECRET;

    // zh -> 중국어 번체, cn -> 중국어 간체로 취급
    private static final Map<String, Map<String, Boolean>> possibleSourceTargetLanguageMap = new HashMap<>() {{
        put("ko", new HashMap<>() {{
            put("en", true);
            put("ja", true);
            put("zh", true);
            put("cn", true);
            put("vi", true);
            put("id", true);
            put("th", true);
            put("de", true);
            put("ru", true);
            put("es", true);
            put("it", true);
            put("fr", true);
        }});
        put("en", new HashMap<>() {{
            put("ko", true);
            put("ja", true);
            put("zh", true);
            put("cn", true);
            put("fr", true);
        }});
        put("ja", new HashMap<>() {{
            put("ko", true);
            put("zh", true);
            put("cn", true);
            put("en", true);
        }});
        put("cn", new HashMap<>() {{
            put("ko", true);
            put("zh", true);
            put("en", true);
            put("ja", true);
        }});
        put("zh", new HashMap<>() {{
            put("ko", true);
            put("cn", true);
            put("en", true);
            put("ja", true);
        }});
        put("vi", new HashMap<>() {{
            put("ko", true);
        }});
        put("id", new HashMap<>() {{
            put("ko", true);
        }});
        put("th", new HashMap<>() {{
            put("ko", true);
        }});
        put("de", new HashMap<>() {{
            put("ko", true);
        }});
        put("ru", new HashMap<>() {{
            put("ko", true);
        }});
        put("es", new HashMap<>() {{
            put("ko", true);
        }});
        put("it", new HashMap<>() {{
            put("ko", true);
        }});
        put("fr", new HashMap<>() {{
            put("ko", true);
            put("en", true);
        }});
    }};

    public @Nullable String translate(String text, String sourceLanguage, String targetLanguage) {
        if (!possibleSourceTargetLanguageMap.containsKey(sourceLanguage) ||
                !possibleSourceTargetLanguageMap.get(sourceLanguage).containsKey(targetLanguage))
        {
            logger.debug("from: " + sourceLanguage + "to: " + targetLanguage + " 는 지원하지 않는 언어입니다.");
            return null;
        }

        if (NAVER_CLIENT_ID == null || NAVER_CLIENT_ID.isBlank() ||
                NAVER_CLIENT_SECRET == null || NAVER_CLIENT_SECRET.isBlank()) {
            logger.error("번역 API 키를 설정하지 않았습니다.");
            return null;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", NAVER_CLIENT_ID);
        headers.set("X-Naver-Client-Secret", NAVER_CLIENT_SECRET);
        headers.set("Content-Type", "application/json");

        HttpEntity<PapagoTranslationRequestDTO> request = new HttpEntity<>(PapagoTranslationRequestDTO.builder()
                .source(sourceLanguage)
                .target(targetLanguage)
                .text(text)
                .build(), headers);

        ResponseEntity<PapagoTranslationResponseDTO> response;

        try {
            response = restTemplate.exchange(
                    PAPAGO_API_URL,
                    HttpMethod.POST,
                    request,
                    PapagoTranslationResponseDTO.class
            );
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error(e.getResponseBodyAsString());
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }

        if (response.getBody() == null) {
            logger.warn("파파고 번역 API response body가 null입니다.");
            return null;
        }

        return response.getBody().getTranslatedText();
    }
}
