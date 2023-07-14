package com.emandi.user.config;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class ClientConfig {


    private final WebClient webClient;

    public ClientConfig(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }


    public <K> Mono<K> getProductById(String url, Map<String, ?> pathParams, Class<K> responseType) {
        try {
            return this.webClient.method(HttpMethod.GET)
                    .uri(url, pathParams)
                    .retrieve().bodyToMono(responseType);
        } catch (WebClientResponseException ex) {
            throw ex;
        }
    }
}
