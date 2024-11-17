package com.example.obiexploermobile.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Data
@AllArgsConstructor
public class ExplorerService {

    @Autowired
    private final WebClientService webClientService;

    public String getResults(Map<String, String> params) {
        return this.webClientService.getQuestions("/getQuestoes", params);
    }

    public String getSubCategories(Map<String, String> params) {
        return this.webClientService.getLists("/subcategoria", params);
    }

    public String getTopics(Map<String, String> params) {
        return this.webClientService.getLists("/topico", params);
    }

    public String getTestYear(Map<String, String> params) {
        return this.webClientService.getLists("/anoProva", params);
    }

    public String getLevel(Map<String, String> params) {
        return this.webClientService.getLists("/nivel", params);
    }

    public String getModality(Map<String, String> params) {
        return this.webClientService.getLists("/modalidade", params);
    }

    public String getPhase(Map<String, String> params) {
        return this.webClientService.getLists("/fase", params);
    }

    public String getCategory(Map<String, String> params) {
        return this.webClientService.getLists("/categoria", params);
    }

    public String getDifficulty(Map<String, String> params) {
        return this.webClientService.getLists("/dificuldade", params);
    }
}
