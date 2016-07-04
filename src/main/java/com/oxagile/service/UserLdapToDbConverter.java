package com.oxagile.service;

import com.oxagile.model.database.UserDb;
import com.oxagile.model.ldap.UserLdap;

import java.util.List;

public interface UserLdapToDbConverter {

    UserDb convertUserLdapToDb(UserLdap userLdap);

    List<UserDb> convertUsersLdapToDb(List<UserLdap> userLdapList);

}
