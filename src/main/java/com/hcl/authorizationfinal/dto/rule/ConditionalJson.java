package com.hcl.authorizationfinal.dto.rule;

import java.util.List;

public class ConditionalJson {
    private String combinator;
    private List<Rule> rules;

    public String getCombinator() {
        return combinator;
    }

    public void setCombinator(String combinator) {
        this.combinator = combinator;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
// Getters and Setters
}