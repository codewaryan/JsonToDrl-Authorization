package com.hcl.authorizationfinal.jsontodrl.impl;

import com.hcl.authorizationfinal.dto.rule.CreateBusinessRuleInputJson;
import com.hcl.authorizationfinal.dto.rule.Rule;
import com.hcl.authorizationfinal.jsontodrl.JsonToDrlConvertor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JsonToDrlConvertorImpl implements JsonToDrlConvertor {

    private static final String DRL_HEADER = "package com.hcl.authorization.drools;\n" +
            "import com.hcl.authorizationfinal.dto.facts.User;\n" +
            "import com.hcl.authorizationfinal.dto.DroolAction;\n" +
            "dialect \"java\"\n";

    private static final String RULE_TEMPLATE = "rule \"%s\"\n" +
            "when\n" +
            "$user: User(%s)\n" +
            "then\n" +
            "    DroolAction droolAction = new DroolAction();\n" +
            "    droolAction.setAction(\"ALLOWED\");\n" +
            "    showResults.showText(\"showResults Incident Manager Role Granted\");\n" +
            "    sh.showText(\"sh Access has been granted to Incident Manager\");\n" +
            "end\n";

    @Override
    public String convertJsonToDrl(CreateBusinessRuleInputJson businessRuleInputJson) {
        StringBuilder droolsRules = new StringBuilder(DRL_HEADER);
        processRules(businessRuleInputJson.getConditionalJson().getRules(), droolsRules);
        return droolsRules.toString();
    }

    private void processRules(List<Rule> rules, StringBuilder droolsRules) {
        StringBuilder combinedConditions = new StringBuilder();

        for (Rule rule : rules) {
            String conditions = generateConditions(rule);
            if (!conditions.isEmpty()) {
                if (combinedConditions.length() > 0) {
                    combinedConditions.append(" && ");
                }
                combinedConditions.append(conditions);
            }
            // Recursively process nested rules
            if (rule.getRules() != null && !rule.getRules().isEmpty()) {
                processRules(rule.getRules(), droolsRules);
            }
        }

        // Add to the final rule
        droolsRules.append(String.format(RULE_TEMPLATE, generateUniqueRuleName(), combinedConditions.toString()));
    }

    private String generateConditions(Rule rule) {
        String field = rule.getField();
        String operator = rule.getOperator();
        String value = (rule.getValue() != null) ? rule.getValue().getValue() : null;
        String condition = "";

        if (value == null) {
            // Handle case where value is null, possibly logging an error or skipping the rule
            return condition; // Skip if value is null
        }

        switch (field) {
            case "CompanyName":
                condition = String.format("companyName == \"%s\"", value);
                break;
            case "Module":
                condition = String.format("module == \"%s\"", value);
                break;
            case "CreatedBy":
                condition = String.format("createdBy == \"%s\"", value);
                break;
            case "AssignTo":
                condition = String.format("assignTo == \"%s\"", value);
                break;
            case "Approver":
                condition = String.format("approver == \"%s\"", value);
                break;
            case "RoleId":
                condition = String.format("roleId in (%s)", value.replace(",", ", "));
                break;
            case "GroupId":
                condition = String.format("groupId in (%s)", value.replace(",", ", "));
                break;
            case "AssociatedCompany":
                condition = String.format("companyId in (%s)", value.replace(",", ", "));
                break;
            default:
                break;
        }

        return condition;
    }

    private String generateUniqueRuleName() {
        return "Generated Rule " + UUID.randomUUID().toString();
    }
}
