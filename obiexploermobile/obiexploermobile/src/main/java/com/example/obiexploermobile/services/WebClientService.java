package com.example.obiexploermobile.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Optional;

@Data
@Service
public class WebClientService {

    private final WebClient webClient;

    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://obiexplorer.lucianaritaguedes.com.br/api/").build();
    }

    public String getQuestions(String endpoint, Map<String, String> queryParams) {
        return webClient
                .get()
                .uri(uriBuilder -> {
                    uriBuilder.path(endpoint);
                    queryParams.forEach((param, value) -> {
                        if (!(param.toLowerCase().contains("titulo") || param.toLowerCase().contains("enunciado"))) {
                            param += "[]";
                        }
                        if (value.toLowerCase().contains("selecione")) {
                            value = "";
                        }
                        uriBuilder.queryParamIfPresent(param, Optional.of(value));
                    });
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getLists(String endpoint, Map<String, String> queryParams) {
        return webClient
                .get()
                .uri(uriBuilder -> {
                    uriBuilder.path(endpoint);
                    queryParams.forEach(uriBuilder::queryParam);
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
