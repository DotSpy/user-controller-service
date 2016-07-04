package com.oxagile.service;

import com.oxagile.model.database.UserDb;
import com.oxagile.model.dto.UserDTO;
import com.oxagile.model.ldap.UserLdap;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    List<UserLdap> getAllUsersLdap();

    List<UserDb> getAllUsersDb();

    void saveUserDb(UserDb userDb);

    void saveUserLdap(UserLdap userLdap);

    void saveUsersDb(List<UserDb> userDbs);

    void saveUsersLdap(List<UserLdap> userLdaps);

    void deleteUserDb(UserDTO userDto);

    List<UserDTO> findUsersByDepartment(String departmentName);

    void updateUsersLdap(List<UserLdap> userLdaps);

    void updateUsersDb(List<UserDb> userDbs);

    void synchronizeLdapAndDb();

}
