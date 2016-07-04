package com.oxagile.model.dto;

public enum UserRoleEnum {
    SITE_OWNER("SiteOwner"), ACCOUNT_OWNER("Owner"), ACCOUNT_ADMIN("Administrator");

    private String roleName;

    UserRoleEnum(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
