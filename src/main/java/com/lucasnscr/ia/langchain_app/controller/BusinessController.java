package com.lucasnscr.ia.langchain_app.controller;

import com.lucasnscr.ia.langchain_app.service.BusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping
    public String home() {
        return "index";
    }
    @PostMapping("/ask")
    public ResponseEntity<String> ask(@RequestBody String question) {
        try {
            return ResponseEntity.ok(businessService.askQuestion(question));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Sorry, I can't process your question right now.");
        }
    }
}
