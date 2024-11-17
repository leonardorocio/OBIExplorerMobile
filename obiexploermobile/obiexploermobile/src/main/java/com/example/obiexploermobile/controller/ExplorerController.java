package com.example.obiexploermobile.controller;

import com.example.obiexploermobile.services.ExplorerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Data
public class ExplorerController {

    @Autowired
    private final ExplorerService explorerService;

    @GetMapping("/questions")
    public ResponseEntity<String> getQuestions(@RequestParam(required = false) Map<String, String> params) {
        return ResponseEntity.ok(this.explorerService.getResults(params));
    }

    @GetMapping("/subcategories")
    public ResponseEntity<String> getSubCategories(@RequestParam(required = false) Map<String, String> params){
        return ResponseEntity.ok(this.explorerService.getSubCategories(params));
    }

    @GetMapping("/topics")
    public ResponseEntity<String> getTopics(@RequestParam(required = false) Map<String, String> params){
        return ResponseEntity.ok(this.explorerService.getTopics(params));
    }

    @GetMapping("/testYears")
    public ResponseEntity<String> getTestYears(@RequestParam(required = false) Map<String, String> params){
        return ResponseEntity.ok(this.explorerService.getTestYear(params));
    }

    @GetMapping("/level")
    public ResponseEntity<String> getLevel(@RequestParam(required = false) Map<String, String> params){
        return ResponseEntity.ok(this.explorerService.getLevel(params));
    }

    @GetMapping("/modality")
    public ResponseEntity<String> getModality(@RequestParam(required = false) Map<String, String> params){
        return ResponseEntity.ok(this.explorerService.getModality(params));
    }

    @GetMapping("/phase")
    public ResponseEntity<String> getPhase(@RequestParam(required = false) Map<String, String> params){
        return ResponseEntity.ok(this.explorerService.getPhase(params));
    }

    @GetMapping("/category")
    public ResponseEntity<String> getCategory(@RequestParam(required = false) Map<String, String> params){
        return ResponseEntity.ok(this.explorerService.getCategory(params));
    }

    @GetMapping("/difficulty")
    public ResponseEntity<String> getDifficulty(@RequestParam(required = false) Map<String, String> params){
        return ResponseEntity.ok(this.explorerService.getDifficulty(params));
    }
}
