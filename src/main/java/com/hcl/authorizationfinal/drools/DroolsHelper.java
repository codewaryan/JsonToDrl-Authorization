package com.hcl.authorizationfinal.drools;

import com.hcl.authorizationfinal.dto.facts.User;
import com.hcl.authorizationfinal.dto.facts.*;

public class DroolsHelper {

    // Example method to check if the role ID exists
    public static boolean isRoleIdExists(User user, String roleId) {
        // Example logic: check if user's role matches one of the role IDs
        return user.getRoleIds().contains(roleId);
    }

    // Example method to check if the company ID exists
    public static boolean companyIdExists(User user, String companyId) {
        // Example logic: check if user's company matches the company ID
        return user.getCompanyIds().contains(companyId);
    }

    // Example method to check if the group ID exists
    public static boolean isGroupIdExists(User user, String groupId) {
        // Example logic: check if user's group matches the group ID
        return user.getGroupIds().contains(groupId);
    }

    // Example method to check if the company name matches
    public static boolean isCompanyNameEquals(User user, String companyName) {
        // Example logic: check if user's company name matches
        return user.getCompanyName().equals(companyName);
    }

    // Example method to check if the module matches
    public static boolean isModuleEquals(User user, String module) {
        // Example logic: check if user's module matches
        return user.getModule().equals(module);
    }

    // Example method to check if created by user matches
    public static boolean isCreatedByEquals(User user, String createdBy) {
        // Example logic: check if user was created by the specified creator
        return user.getCreatedBy().equals(createdBy);
    }

    // Example method to check if assigned user matches
    public static boolean isAssignToEquals(User user, String assignTo) {
        // Example logic: check if user is assigned to the specified assignee
        return user.getAssignTo().equals(assignTo);
    }

    // Example method to check if approver matches
    public static boolean isApproverEquals(User user, String approver) {
        // Example logic: check if user has the specified approver
        return user.getApprover().equals(approver);
    }
}
