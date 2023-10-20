package kr.ecocow.ecomovie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PapagoTranslationResponseDTO {
    private MessageDTO message;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class MessageDTO {
        @JsonProperty("@type")
        private String type;

        @JsonProperty("@service")
        private String service;

        @JsonProperty("@version")
        private String version;

        private ResultDTO result;

        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        public static class ResultDTO {
            private String srcLangType;
            private String tarLangType;
            private String translatedText;
        }
    }

    public @Nullable String getTranslatedText() {
        if (message != null && message.getResult() != null) {
            return message.getResult().getTranslatedText();
        }

        return null;
    }
}
