package com.hcl.authorizationfinal.controller;

import com.hcl.authorizationfinal.dto.rule.CreateBusinessRuleInputJson;
import com.hcl.authorizationfinal.service.BusinessRuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessRuleController {

    private final BusinessRuleService businessRuleService;

    public BusinessRuleController(BusinessRuleService businessRuleService) {
        this.businessRuleService = businessRuleService;
    }

    @PostMapping("/createBusinessRule")
    public ResponseEntity<String> createBusinessRule(@RequestBody CreateBusinessRuleInputJson inputJson) {
        try {
            businessRuleService.processBusinessRule(inputJson);
            return ResponseEntity.ok("Business rule created successfully");
        } catch (Exception e) {
            // Handle specific exceptions as needed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating business rule: " + e.getMessage());
        }
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + e.getMessage());
    }
}
