package com.oxagile.dao;

import com.oxagile.model.database.DepartmentDb;
import com.oxagile.model.database.UserDb;

import java.util.List;

public interface UserDao {

    List<UserDb> getAllUsers();

    void saveUser(UserDb userDb);

    void saveUsers(List<UserDb> userDbs);

    UserDb findByName(String name);

    UserDb findByMailNickName(String nickName);

    List<UserDb> findByDepartment(DepartmentDb departmentDb);

    void deleteUser(UserDb userDb);

    UserDb findByEmail(String email);

    void updateUser();

}
