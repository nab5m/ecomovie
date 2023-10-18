package kr.ecocow.ecomovie.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI openAPI(@Value("v1.0") String appVersion) {
        Info info = new Info().title("EcoMovie").version(appVersion)
                .description("EcoMovie API 문서입니다.")
                .contact(new Contact().name("nab5m")
                        .url("https://github.com/nab5m/ecomovie")
                        .email("disnwkdl420@gmail.com"));

        return new OpenAPI()
                .info(info);
    }
}