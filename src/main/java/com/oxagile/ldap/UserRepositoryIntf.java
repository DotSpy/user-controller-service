package com.oxagile.ldap;

import com.oxagile.model.ldap.UserLdap;

import java.util.List;

public interface UserRepositoryIntf {
    List<UserLdap> getAllUsers();
}
