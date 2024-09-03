package com.hcl.authorizationfinal.dto.facts;

import java.util.List;

public class User {
    private String userId;
    private String userName;
    private String companyName;
    private List<Integer> roleIds;
    private List<Integer> groupIds;
    private List<Integer> companyIds;  // Added for AssociatedCompany
    private String module;
    private String createdBy;
    private String assignTo;
    private String approver;

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public List<Integer> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<Integer> groupIds) {
        this.groupIds = groupIds;
    }

    public List<Integer> getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(List<Integer> companyIds) {
        this.companyIds = companyIds;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    // Utility Methods

    public boolean isRoleIdExists(Integer roleId) {
        return roleIds != null && roleIds.contains(roleId);
    }

    public boolean isGroupIdExists(Integer groupId) {
        return groupIds != null && groupIds.contains(groupId);
    }

    public boolean isCompanyIdExists(Integer companyId) {
        return companyIds != null && companyIds.contains(companyId);
    }

    public boolean isCompanyNameEquals(String companyName) {
        return companyName != null && companyName.equals(this.companyName);
    }

    public boolean isModuleEquals(String module) {
        return module != null && module.equals(this.module);
    }

    public boolean isCreatedByEquals(String createdBy) {
        return createdBy != null && createdBy.equals(this.createdBy);
    }

    public boolean isAssignToEquals(String assignTo) {
        return assignTo != null && assignTo.equals(this.assignTo);
    }

    public boolean isApproverEquals(String approver) {
        return approver != null && approver.equals(this.approver);
    }
}
