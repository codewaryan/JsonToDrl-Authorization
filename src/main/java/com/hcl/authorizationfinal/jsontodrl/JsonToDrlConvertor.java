package com.hcl.authorizationfinal.jsontodrl;

import com.hcl.authorizationfinal.dto.rule.CreateBusinessRuleInputJson;

public interface JsonToDrlConvertor {

    String convertJsonToDrl(CreateBusinessRuleInputJson businessRuleInputJson);

}
