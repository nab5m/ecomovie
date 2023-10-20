package kr.ecocow.ecomovie.config;

import kr.ecocow.ecomovie.constant.AppendToResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Optional;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new AppendToResponseConverter());
    }

    public static class AppendToResponseConverter implements Converter<String, AppendToResponse> {
        @Override
        public AppendToResponse convert(String source) {
            Optional<AppendToResponse> convertResult = Arrays.stream(AppendToResponse.values())
                    .filter(value -> value.getRequestParameterName().equals(source))
                    .findFirst();


            return convertResult.orElse(null);
        }
    }
}
