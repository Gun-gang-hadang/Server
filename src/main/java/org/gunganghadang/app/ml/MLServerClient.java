package org.gunganghadang.app.ml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.dto.DietAnalysisMLResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class MLServerClient {
    @Value("${ml.url}")
    private String mlUrl;

    public DietAnalysisMLResponseDto analyzeDietImage(@RequestParam("image") MultipartFile image) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        WebClient webClient = WebClient.create(mlUrl);
        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
        formData.add("image", new MultipartInputStreamFileResource(image.getInputStream(), image.getOriginalFilename()));

        String response = webClient.post()
                .uri("/api/v1/analyze/image")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(formData))
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofMillis(20000))
                .blockOptional().orElseThrow();

        ArrayList<String> food = objectMapper.readValue(response, new TypeReference<ArrayList<String>>() {});
        DietAnalysisMLResponseDto dietAnalysisMLResponseDto = new DietAnalysisMLResponseDto();
        dietAnalysisMLResponseDto.setFoodList(food);

        image.getInputStream().close();
        return dietAnalysisMLResponseDto;
    }

    // MultipartMap에 MultipartFile의 바이트를 추가
    static class MultipartInputStreamFileResource extends InputStreamResource {
        private final String filename;

        MultipartInputStreamFileResource(InputStream inputStream, String filename) throws IOException {
            super(inputStream);
            this.filename = filename;
        }

        @Override
        public String getFilename() {
            return this.filename;
        }

        @Override
        public long contentLength() throws IOException {
            return -1; // we do not want to generally read the whole stream into memory ...
        }
    }
}
