# JsonToDrl-Authorization
Input Json:
{
    "conditionalJson": {
       "combinator": "and",
       "rules": [
          {
             "id": "f4bce6d6-69b7-404b-8c8f-a6e04c3a966e",
             "field": "CompanyName",
             "operator": "=",
             "valueSource": "value",
             "value": {
                "id": "1",
                "value": "HCL Software"
             }
          },
          {
             "id": "782e29e8-e707-4b32-98c2-d03ba3ac385c",
             "field": "Module",
             "operator": "=",
             "valueSource": "value",
             "value": {
                "id": "02",
                "value": "Incident"
             }
          },
          {
             "id": "466c769e-a4b1-407a-8226-d8cf271eaf0e",
             "rules": [
                {
                   "id": "cef30f63-2761-4437-b987-e0961e9ba448",
                   "field": "RoleId",
                   "operator": "in",
                   "valueSource": "value",
                   "value": {
                      "id": "10",
                      "value": "1,2,3,4,5,6,7,8"
                   }
                },
                {
                   "id": "cef30f63-2761-4437-b987-e0961e9ba448",
                   "field": "AssociatedCompany",
                   "operator": "in",
                   "valueSource": "value",
                   "value": {
                      "id": "10",
                      "value": "100,200,300,400,500,600,700,800"
                   }
                }
             ],
             "combinator": "and",
             "not": false
          },
          {
             "id": "469ceec3-ba80-4ce2-9122-25748f87186e",
             "field": "GroupId",
             "operator": "in",
             "valueSource": "value",
             "value": {
                "id": "12",
                "value": "10,11,12,13,14,15"
             }
          },
          {
             "id": "469ceec3-ba80-4ce2-9122-25748f87186e",
             "field": "CreatedBy",
             "operator": "=",
             "valueSource": "value",
             "value": {
                "id": "12",
                "value": "LoginUser"
             }
          },
          {
             "id": "469ceec3-ba80-4ce2-9122-25748f87186e",
             "field": "AssignTo",
             "operator": "=",
             "valueSource": "value",
             "value": {
                "id": "12",
                "value": "LoginUser"
             }
          },
          {
             "id": "469ceec3-ba80-4ce2-9122-25748f87186e",
             "field": "Approver",
             "operator": "=",
             "valueSource": "value",
             "value": {
                "id": "12",
                "value": "LoginedUser"
             }
          }

       ]
    }
}

Output drl file:

package com.hcl.authorization.drools;
import com.hcl.authorizationfinal.dto.facts.User;
import com.hcl.authorizationfinal.dto.DroolAction;
dialect "java"
rule "Generated Rule 20033949-25ed-4d04-b04c-a82eb28fc67a"
when
$user: User(roleId in (1, 2, 3, 4, 5, 6, 7, 8) && companyId in (100, 200, 300, 400, 500, 600, 700, 800))
then
    DroolAction droolAction = new DroolAction();
    droolAction.setAction("ALLOWED");
    showResults.showText("showResults Incident Manager Role Granted");
    sh.showText("sh Access has been granted to Incident Manager");
end
rule "Generated Rule 90a5f082-36d3-40ba-93fb-810a517d02ef"
when
$user: User(companyName == "HCL Software" && module == "Incident" && groupId in (10, 11, 12, 13, 14, 15) && createdBy == "LoginUser" && assignTo == "LoginUser" && approver == "LoginedUser")
then
    DroolAction droolAction = new DroolAction();
    droolAction.setAction("ALLOWED");
    showResults.showText("showResults Incident Manager Role Granted");
    sh.showText("sh Access has been granted to Incident Manager");
end



